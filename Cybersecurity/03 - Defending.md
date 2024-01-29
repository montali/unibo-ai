# Defending from cyber attacks

## External cybersecurity consultants

The first fundamental step to defend correctly an organization is to study the organization itself to understand its:
* Sector: Dimension, market, products, services
* Vision and commitment of top management
* Structure (formal and informal), internal and external business processes
* maturity level of digitalization and cybersecurity
* On-premise/outsourcing/hybrid orientation, suppliers
* ...

Then a good cybersecurity consultant should propose **customized changes FIRST at the governance level and ONLY THEN at the technological level**, considering the design, implementation and 24/7 management of the chosen solution.

Lots of (bad) cyber security vendors and consultants try to sell whatever they have in stock, often technology-only solutions (""magic boxes""), without tailoring it to the target organization.
This is in part because cybersecurity is currently an asymmetric market (most customers don't know anything about cybersecurity) and because a good cybersecurity requires a (possibly costly) reorganization with an effort without end date and apparently doesn't immediately lead to an increase in value, so it's hard to sell a good cybersecurity solution.

Part of the the solution to sell good cybersecurity to skeptical organizations is **not to hinge on fear but to sell security as a feature** that can increase the value of products (""embedded security"").
Regulations on cybersecurity and data protection are becoming one of the main motivators for security investments, but **a company can be compliant without proper security in place**, it's important to convince management to really reach security. Also, a lot of norms are focused on technology, although recently some norms are improving their focus on business.
Still, this alone might not be enough to convince them, but on the long term people, organizations and regulators can realize the importance of security and reliability for their safety and bottom line.

Understanding who is hiring the cybersecurity service is fundamental:
* project managers => need support on short-term projects
* functional / middle level managers => need support on medium term on parts of the organization
* top managers => need support on long term strategic decisions and restructuring of the whole organization

## Internal cybersecurity department

Cybersecurity used to be part of the IT department, but this is not sufficient because it considers security only as a technological problem and because the controller (cybersecurity) and controlled (IT) cannot be in the same department. Today companies with a good security strategy have **distinct departments: IT (led by the CIO) and Cybersecurity (led by the CISO)**.

A good CISO should not create obstacles to business by following blindly a cybersecurity ""religion"": he must know well its organization's business lines and processes to protect and empower them.

## Maturity level models

To this day it's still hard to estimate the Return On Investment of cybersecurity. Around 2009 it was studied a "Return On Security Investment" but it didn't work. Without a good ROI model for cyber-security we need a qualitative evaluation of cyber-security maturity level.

Old maturity level evaluation models focused only on technologies. This is not enough.
Modern models include **People, Process and Technology** ("PPT vision").

Once maturity levels are evaluated, a realistic improvement project can't jump directly many levels. It's important to plan the rise level by level, so that visible results and feedbacks are frequent and verifiable. Reaching the next level becomes more costly at each level.

## Cyber-security approaches

- **Reactive**
    - no investment in prevention, only react to attacks
    - immature, set up for failure
    - Steps to improve an organization that is still using this approach:
        1. Decide how much of the long transformation process can be handled **on premise** and what needs to be **outsource**; this includes choosing whether to hire or rent a skilled professional, evaluating whether to move IT to the cloud and what aspect will still be in the organization's hands, ...
        2. Before thinking to advanced techniques like penetration testing, implement **basic survival needs**: physical security, installing antivirus, updating regularly OS and software, WELL CONFIGURED firewall, good authentication mechanism, SECURE backups, protect communication with anti-spam/anti-phishing
        3. Identify groups for network segmentation, define roles for authorization (both management decisions), identify the most important data to encrypt, data sharing protection
- **Compliance-driven**
    - invests to remain compliant to some standard or certification only because clients require it
    - sometimes secure only on paper, **compliance and security only partially overlap**
    - Important difference between
        - Norm/Regulation/Law (ex. GDPR): imposed by a government
        - Standard de jure (ex. ISO 27001): defined by an international institution
        - Guideline/Framework (ex. NIST)/Best practice (ex. PCI DSS)/Book of knowledge: voluntary
- **Risk-based**
    - Best approach, proactive
    - The modern definition of risk is the effect of uncertainty on the possibility of achieving the organization's objectives (=> the first step is knowing the organization's objectives and risk appetite!)
    - In cybersecurity risk is only qualitative as we don't have a way to quantify it
    - **Risk management** is a continuous (24/7) process requiring management that concerns cyber risks (physical, digital and human)
        1. Risk **assessment**
            - Risk **identification** (know structure, processes, resources and priorities; set up continuous asset management; identify the attack surface)
            - Risk **analysis**: impossible to consider the full attack surface, consider only the most probable targets
            - Risk **evaluation**: generates a risk matrix or a similar report 
        2. Risk **treatment**: technical staff can suggest countermeasures but it's the managers responsibility to take this decision
            1. **Policies** (ex. only group X can access area Y)
            2. **Procedures** (ex. in order to access area Y people must pass their badge through a scanner to verify they belong to group X)
            3. **Technologies** (ex. we need a badge scanner and a badge for everyone in group X)
    - **Cybersecurity by design**: risk management is an integral part of decision making
    - Modern norms include risk management (ex. Privacy Impact Analysis and Data Privacy Impact Analysis in GDPR)

#### NIST Framework

Framework by the homonymous organization that covers cybersecurity **Governance** plus the cybersecurity lifecycle in 5 steps:
1. **Identify** processes, assets, available resources and priorities
2. **Protect**
3. **Detect**
4. **Respond**
5. **Recover**
6. Collect lessons learned and repeat

#### ISO/IEC 270xx

Family of standards, referred together with the year it was las revised, ex. ISO/IEC 27001:2022, typically abbreviated to ISO 27001.
27001 aims to create an Information Security Management System (ISMS), a top-down approach with few technological details and lots of policies and procedures to **reduce risk** and **ensure business continuity**.
Uses the Deming PDCA cycle for **continuous improvement**.


## Full top-down risk-based approach

1. Analyze the **context** in which the company operates
2. Understand the company business **goals**
3. Analyze the **risks**
4. Implement **policies**
5. Operate:
    - Implement **procedures**
    - Assign **responsibilities**
    - **Handle risks** with 4 possible "T" alternatives:
        - Tolerate: You know that you have a vulnerability but you accept it because it has an extremely low probability or you can't possibly have enough resources to handle it 
        - Terminate: Stop using the vulnerable service or technology
        - Transfer: share the risk (ex. outsourcing or insurance)
        - Treat: Work to prevent, detect and respond; if it is possible, it's the best alternative
    - Detect, respond and recover from attacks
6. Keep **verifying** and iterating

### Incident detection and response

- **Incident response must be prepared ahead of time**, for all severity levels (troubles, incidents and disasters). Often it's outsourced (Managed Detection and Response, MDR) because it's extremely far away from most organizations' core business and requires tough human and technical skills.
- **Multiple possible teams** (multiple interpretations for each team type exist):
    - Network Operation Center (**NOC**): monitoring the overall network to ensure availability, typically not meant against malfunctions, not cyber-attacks
    - Security Operation Center (**SOC**): monitoring the overall network to detect cyber-attacks
    - Computer Security Incident Response Team (**CSIRT**): coordinates responses to cybersecurity incidents. It can include a firs line of human filtering possible true alarms, a second line to investigate them, and a third line to  proactively hunt for malicious traces.
    - Computer Emergency Response Team (**CERT**): only in USA, registered mark, CSIRT that partners with government and industry for prevention and threat intelligence
- It's important to have a **SIEM** (Security information and event management) tool with agents in all devices to monitor all events and facilitate the response team work to investigate the source of the attack
- **Cyber threat intelligence** is fundamental, it requires multiple aspects:
    - global view of the organization's and the wole world's context
    - Techniques, Tactics and Procedures (TTP) of possible threat actors
    - Indicators of Compromise (IoC)
    - Internal data feeds
- The first part of response is to understand the severity of the attack (**triage**) based on potential social, economical, reputational and technical consequences
- **Communication** (to press, employees, authorities) is fundamental during incident response
- In case the incident has legal repercussions, in the post-incident phase forensic investigations should take place

## Zero-trust security

Modern organizations don't have a clear inside-outside distinction (due to cloud, WFH, shadow IT, ...), so external threats exist in the network at all times and the user's position or device can't define its trust.
Solution:
- Prefer full-cloud to hybrid
- Strong authentication
- Precise authorization: least privilege principle
- **Zero Trust Architecture (ZTA)**: Every operation must require Authentication AND Authorization, all devices are treated as external (no privileges) until authenticated. Behave as is malware is always present in at least one device.
    - **Every device, user and request must always be authenticated**
        - Strong authentication: all requests should authenticate, for example through token-based authentication like oauth2
        - Ideally Multi Factor Authentication
    - Authorization is achieved through fine-grained rules and **least-privilege principle**
        - Implicit trust zones (communications between devices without A&A) must be eliminated
        - All communications must be secured
    - Most **A&A policies must be dynamic and adaptive**: they take into consideration as many data sources as possible
        - behavioral attributes (deviations from observed usage patterns, ...)
        - requesting asset state (software versions, installed credentials, ...)
        - environmental attributes (reported active attacks, ...)
        - ...
    - **All network traffic should be monitored**, logged and inspected to detect attacks and configuration vulnerabilities in policies

Logical view of components:
- Policy Decision Point (PDP)
    - Handles A&A, fetches all relevant data sources and decides who is authorized to do what
    - Composed by Policy Engine and Policy Administrator
    - Part of the control plane
    - Currently no standard on how to define policies and on querying APIs, an attempt of standardization is Open Policy Agent (OPA)
- Policy Enforcement Point (PEP)
    - Handles the actual enforcement of the decisions by the PDP
    - Part of the data plane
    - Criteria-based algorithm (in theory best, but causes an explosion of roles and criteria) VS score-based algorithm VS hybrid
    - Singular algorithm (takes into consideration only the communication it's handling) VS contextual algorithm (takes into consideration history)

In some ZTAs the PEP is an actual component through which all communications must pass. In other the PEP is distributed, for example throughout the network architecture. Possible approaches:
- Use the identity of actor as key policy factor with a central PEP
- Micro-segmentation: Place individual (or groups of) critical resources on a specific network segment protected by a secure gateway that acts as PEP. Harder to implement and manage but prevents a central PEP, that can be a single point of failure.
- Leverage the software network infrastructure
    - Software Defined Perimeter through Software Defined Networks
    - Typically on an overlay network at layer 7


BOTH governance and technology are fundamental. **Really hard to implement**, especially when handling legacy components, requires significant resources and persistence in a multi-year effort.
First implemented by Google in 2012 (now offered to other companies as "[BeyondCorp](https://cloud.google.com/beyondcorp)"). Also adopted by US federal government.
NIST defined [seven principles of ZTA](https://nvlpubs.nist.gov/nistpubs/SpecialPublications/NIST.SP.800-207.pdf).
Forrester proposed a five-step process:
1. Identify all resources and data sources
2. Map transition flows and communication patterns
3. Design the ZTA with micro-perimeters based on the typical transactions
4. Implement the monitoring and enforcement system
5. Write the rules on the segmentation gateway based pm the expected behavior. Embrace cybersecurity automation and orchestration to maintain rules.

