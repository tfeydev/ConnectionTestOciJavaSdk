package techthor.oci;

import com.oracle.bmc.auth.ConfigFileAuthenticationDetailsProvider;

/**
 * Utility class for providing Oracle Cloud Infrastructure authentication details.
 *
 * <p>This class loads OCI credentials from the standard configuration file
 * located at {@code ~/.oci/config}. The profile name defaults to {@code DEFAULT}
 * but can be adjusted if required.</p>
 *
 * <p>The returned {@link ConfigFileAuthenticationDetailsProvider} can be used to
 * build service clients for the OCI Java SDK.</p>
 */
public class OciAuthUtil {

    /**
     * Creates an authentication provider from the OCI configuration file.
     *
     * @return an initialized {@link ConfigFileAuthenticationDetailsProvider}
     * @throws Exception if the configuration file cannot be read
     */
    public static ConfigFileAuthenticationDetailsProvider getProvider() throws Exception {
        // Initialize provider using the config file and profile "DEFAULT"
        // This expects ~/.oci/config to exist and contain valid credentials.
        return new ConfigFileAuthenticationDetailsProvider("~/.oci/config", "DEFAULT");
    }
}
