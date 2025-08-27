# OCI Auth Check

## Overview
**OCI Auth Check** is a minimal Java program to verify that your local Oracle Cloud Infrastructure (OCI) Java SDK setup is working correctly.  
It authenticates using your `~/.oci/config` credentials, connects to OCI's Identity service, and retrieves your current user information.

This is useful as a **health check** when:
- Setting up a new development environment for OCI.
- Testing credential validity.
- Ensuring network and SDK connectivity before running larger projects.

---

## Prerequisites
- Java **17** or newer (Java 21 supported).
- Apache Maven installed.
- An existing OCI account and generated API keys.
- A valid OCI configuration file at `~/.oci/config` with a `[DEFAULT]` profile.

---

## Configuration
The program expects the configuration file in the standard location:

---

📁 Projektstruktur
```
oci-auth-check/
├── pom.xml
├── README.md
└── src/
└── main/
├── java/
│   └── techthor/
│       └── oci/
│           ├── OciAuthUtil.java
│           └── OciAuthCheck.java
└── resources/
└── simplelogger.properties
```


Expected successful output:

    ✅ Connection successful!
    👤 User Display Name: your.email@example.com
    🆔 User OCID: ocid1.user.oc1..abcdef...


## Dependencies

- OCI Java SDK Common (oci-java-sdk-common)
- OCI Identity SDK (oci-java-sdk-identity)
- OCI HTTP Client (Jersey) (oci-java-sdk-common-httpclient-jersey)
- SLF4J Simple logger (slf4j-simple)