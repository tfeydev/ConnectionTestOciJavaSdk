package techthor.oci;

import com.oracle.bmc.identity.IdentityClient;
import com.oracle.bmc.identity.requests.GetUserRequest;
import com.oracle.bmc.identity.responses.GetUserResponse;
import com.oracle.bmc.auth.ConfigFileAuthenticationDetailsProvider;

/**
 * A simple program that verifies connectivity and authentication
 * to Oracle Cloud Infrastructure (OCI) by retrieving the current user's details.
 *
 * <p>This is intended as a minimal "health check" for OCI Java SDK setups.
 * If authentication succeeds, it will display the username and OCID for the
 * configured profile.</p>
 *
 * <p>Requires:
 * <ul>
 *     <li>OCI Java SDK dependencies in Maven</li>
 *     <li>OCI config file at {@code ~/.oci/config}</li>
 *     <li>Valid credentials in the specified profile</li>
 * </ul>
 * </p>
 */
public class OciAuthCheck {

    /**
     * The entry point of the application.
     *
     * @param args optional command-line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            // Load the authentication details provider from the config file
            ConfigFileAuthenticationDetailsProvider provider = OciAuthUtil.getProvider();

            // Create an IdentityClient using the loaded credentials
            try (IdentityClient identityClient = IdentityClient.builder().build(provider)) {

                // Get the user's OCID from the authentication provider
                String userOcid = provider.getUserId();

                // Create and send a request to retrieve the user's details from OCI
                GetUserResponse response = identityClient.getUser(
                        GetUserRequest.builder().userId(userOcid).build()
                );

                // Output a success message and the retrieved user details
                System.out.println("✅ Connection successful!");
                System.out.println("👤 User Display Name: " + response.getUser().getName());
                System.out.println("🆔 User OCID: " + response.getUser().getId());
            }
        } catch (Exception e) {
            // Output any failure messages for troubleshooting
            System.err.println("❌ Connection failed: " + e.getMessage());
        } finally {
            // Ensure clean JVM exit to prevent lingering SDK background threads in Maven exec
            System.exit(0);
        }
    }
}
