# Handling vulnerabilities

Threats can do damage only if the target is vulnerable. **We can't eliminate threats** and we can't remove all vulnerabilities, **we can only prioritize and handle vulnerabilities** and mitigate damages.

Vulnerabilities does not affect only technology but the whole **attack surface**:

- **Internal people**
    - Managers
    - SysAdmins
    - Employees
    - Password and credential management
    - Privilege abuse
    - Social media
    - Business Email Compromise
- **Technology**
    - Employees' devices and apps installed on them
    - Data centers
        - Web servers and other front-facing technical infrastructure
        - Directory services, DBs and other internal technical infrastructure
    - Internal network
    - Software and web services
    - IoT devices
    - User facing devices (POS, ATM, ...)
    - Lax or faulty physical and virtual access control
    - Missing or insecure backups
- **Supply chain**
    - Cloud services
    - Operating systems and apps on devices
    - Libraries in software
    - Employees
    - Supplier employees' devices and apps installed on them
    - Data centers
    - Energy, Gas, Connectivity
    - Single Sign On

## Causes of software vulnerabilities

90% are due to **software errors**. Other causes include **bad installation**, **bad configuration** or usage of illegal or untrusted software.
Vulnerabilities are introduced into software by error due to
- time concerns when trying to deliver software to market with competition
- lack of knowledge about secure programming and A&A (authentication & authorization) by developers

Modern services have other security-related requirements beyond Confidentiality, Integrity and Availability:
- **Safety** for the user/worker
- **Reliability**
- **Scalability**

A **Zero day** vulnerability is a vulnerability **found** but **not yet disclosed** to the vendor and **not patched**.

OWASP Top 10 lists most common vulnerabilities: https://owasp.org/www-project-top-ten/ .

A lot of vulnerabilities can be attributed to the lack of validation and sanitization of the input data:
- Injection (code/SQL/...)
- XXF (reflected/stored)
- SSRF
Misconfiguration vulnerabilities include default configurations, easy credentials, unprotected resources, unused but available resources, ...

## Preventing software vulnerabilities

A proper cybersecurity strategy for a business requires a separate [cyber]security department, separate from the IT department. IT and cybersecurity have different priorities and like all producer-controller couples should be separate.
It's also important to remember security is not just a technology problem: it includes norms, legal issue, people, human factors, business processes, ...
Even if a business does not handle critical infrastructure, if it is part of the supply chain of a critical infrastructure business it should be considered high priority potential target for cyber attacks.

OWASP has a list of useful guides and tools: https://owasp.org/projects/

## Managing software vulnerabilities

Security logging and monitoring is fundamental for attack detection.

MITRE has a lists of:
- weaknesses (**CWE**, https://cwe.mitre.org)
- vulnerabilities (**CVE**, https://cve.mitre.org)
- attack patterns (**CAPEC**, https://capec.mitre.org)

## Cryptography

Cryptography can be used to reach confidentiality and integrity. It is used on data, mainly in storage and in transit. It's rarely used in data in processing (only through omomorphic operations).

Cryptography in transit is implemented through cryptographic protocols.
The most risky part of symmetric cryptography (assuming a correct key length of at least 1024) is the key sharing. In asymmetric cryptography (assuming a correct key length of at least 4096) it's the Certificate Authority, on which the user puts it blind trust.

The IP layer is ideal for cryptographic protocols, as it acts as gatekeeper. So it was the first to see a cryptographic protocol, IPsec, however this creates serious trouble to firewalls so it is widely blocked and currently used mainly by VPNs.
So nowdays most use cases are handled by TCP/UDP with SSL/TLS.

One Time Pad algorithms ara a special category, secure only if the length of the key is at least equal to the message. They are used only for top secret use cases.

## Supply chain attacks

Every organization has many suppliers (legal, consultants, cloud providers, software or hardware vendors, ...) that supply services and products that are deemed not part of the core business.
The "**supply chain**" (or "supply network") includes all external factors introduced by suppliers (organizations, people, activities, information, ...). **"Tier 1" providers** are suppliers with a direct connection; **"tier 2" providers** are suppliers of tier 1 providers; and so on... . Each service provided by each tier has some vulnerabilities.

It's often hard to monitor vulnerabilities in tiers beyond 1. For this reason supply chain is now considered the weakest link in cybersecurity (surpassing software and people).
The introduction of IoT and automation in industry, medicine, ... and the convergence of IT with OT (Operations Technology) thanks to Industry 4.0 means this threat is now common in most industries.
Software supply chain is a particularly relevant source of vulnerabilities.
Recently the USA administration required all federal suppliers to provide a **Software Bill Of Materials (SBOM)** and other requirements. European Union introduced the **Network and Information Security (NIS v2)** directive to establish national strategies and require special security requirements (like CSIRTs; only critical infrastructures in v1, all infrastructure in v2) and their suppliers.

