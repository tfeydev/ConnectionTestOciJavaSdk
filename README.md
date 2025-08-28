# ConnectionTestOciJavaSdk

This Maven-based Java project tests connections to Oracle Cloud Infrastructure (OCI) using the OCI Java SDK. I created it to apply my Java learning (from Udemy courses) to cloud integration, focusing on basic API calls like listing OCI resources. It runs on my RHEL 10 dual-boot system and targets OCI’s Always Free tier.

## What I've Done

- Configured a Maven project with OCI Java SDK dependencies in `pom.xml`.
- Wrote Java code in `src/main/java` to establish OCI connections (e.g., authentication setup).
- Added basic tests in `src/test/java` to verify SDK functionality.
- Tested locally, ensuring compatibility with OCI Always Free resources.

## Installation and Configuration

1. **Prerequisites**:
    - Install Java JDK: `sudo dnf install java-17-openjdk` (on RHEL 10).
    - Install Maven: `sudo dnf install maven`.
    - Set up OCI credentials: Create `~/.oci/config` with your OCI details (from OCI Console). Example:

```script
[DEFAULT]
user=ocid1.user.oc1..<your_user_ocid>
fingerprint=<your_fingerprint>
key_file=/path/to/private_key.pem
tenancy=ocid1.tenancy.oc1..<your_tenancy_ocid>
region=eu-frankfurt-1
```

2. Clone the repo: `git clone https://github.com/tfeydev/ConnectionTestOciJavaSdk.git`

3. Build: `mvn clean install`

**Verification**: Check `target/classes` exists (`ls target/classes`); confirm no errors in Maven output (`BUILD SUCCESS`).

## Testing

- Run tests: `mvn test`
- Verify dependencies: `mvn dependency:tree` (should list OCI Java SDK).

**Verification**: Ensure `mvn test` outputs no failures. If connecting to OCI, check logs for successful API calls (e.g., no authentication errors).

This project complements my OCI deployment work in [code repo](https://github.com/tfeydev/code).