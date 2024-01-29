# Cybersecurity - Introduction

1 + 3 phase approach:

1.	**Identification of the perimeter** and resources to protect, resources available, constraints, ...

Step 2-3-4 (cycle): 

2.	**Prevention**: should take 80% of the time, but we can't prevent everything
3.	**Detection** 
4.	**Response**: If our service runs 24/7 on person isn't enough, someone should be always ready to triage the detected anomaly, mitigate the damage

## Vulnerabilities
Technological vulnerabilities are easier to be fixed than human vulnerabilities.

## Important service characteristics
- Usability
- Resiliency: ability to perform the required services even after internal issues
- Security
- Scalability: Ability to increase performance when required and reduce it when idle
- Complexity transparency: Handle the complexity, hide it and leave to the user a simple experience
- Cost

### Service security

CIA: Desired
- Confidentiality: Data should be served only to authorized entities
- Integrity: Data should be delivered identical to the original to the destination
- Availability: Authorized entities should be able to access the data

DAD: Undesired
- Disclosure
- Alteration
- Destruction 

## Potential damage types

- Compromise the data
- Unavailability of the service/data
- Fraud
- Data exfiltration (harder than sabotage as a return channel needs to be established)
- Loss of credibility
- Extortion: ex. Ransomware, currently the highest risk as it's the easiest to perform and most scalable as you are not focused on a particular target but simply find any vulnerability

Every organization has its own structure and priorities and should act differently to improve its security posture. There is no single simple solution to solve all security problems, even though some salespeople think so.

One of the first tasks to improve security is to analyze potential damages and prioritize resources to defend from threats based on the damage each threat can cause.

## Threat types

- Internal / Supply chain / External human / External natural
- Intentional / Accidental

Focusing on human made threats we can also distinguish:

### Threat actor
Type of human perpetrator

- Motivated by money (vast majority)
  - **nation state actors**
    - most dangerous
    - espionage, sabotage, social control
    - handled by homeland security, intelligence (e.g. CIA, NSA), army
    - mainly interested in critical infrastructures: energy, finance, healthcare, water (plus their suppliers!)
  - **advanced persistent threats (APT)**
    - sophisticated targeted attacks on extended periods of time by professional attackers with significant resources
    - sometimes used as proxy by states or tolerated by states as long as they operate only non-friendly states
    - highly difficult to attribute and find links with states
  - **criminals**
    - not the most dangerous but the most likely for most people and organizations
    - target types
      - looking for "low hanging fruits" (many attacks with low payoff, for example small-medium enterprises)
      - looking for top targets (few attacks with high payoff, for example 1B+ companies)
    - vertically specialized competencies, trading results in criminal marketplaces and with data brokers selling the data for profit
    - beyond actors, includes facilitators (money laundering, ...) and criminal marketplace managers
    - some offer their competencies as a service, including assistance to customers
  - **specialized companies**
    - malware/exploit vendors, data brokers
    - usually they claim to work only for law enforcement, but even assuming this is true it's not necessarily always ethical
  - **competitors**
  - **ex employees**
- Motivated by ideology
  - **people** fighting for an ideology (e.g. Anonymous)
  - **script kiddies**
  - **pathological criminals** (e.g. trying to spy on ex partners)

All actors need:
- info about vulnerabilities
- info about the target: recon and intelligence analysis on technology and people inside (and interacting with) the target
  - Open source intelligence (OSINT)
  - Grey sources (ex. buy information on the dark web)
  - Closed sources
- exploits
- infrastructure for deployment

The full lifecycle of an attack is described by [Lockheed Martin's **cyber kill chain**](https://www.lockheedmartin.com/en-us/capabilities/cyber/cyber-kill-chain.html). This model is actually old by now actually, the steps are not linear anymore, they fork in a network.
A more modern attack lifecycle is [MITRE's Att&ck matrix](https://attack.mitre.org/) which passes from 7 to 14 steps and for each of them lists multiple alternatives.

### Threat vector

The methods that an actor uses to breach an organization.
Most dangerous threat vectors typically originate from state actors, are passed to their friendly APTs and then trickle down to other cyber-criminals.

Threat vectors by target, in descending order of popularity as target:

#### People

1. People are usually the weakest link and the preferred target of threat vectors

Psychology factors: trust, ideology, greed, ...

Main types:
  - **Phishing**
  - **Spear phishing** (impersonating a colleague, boss or other trusted person)

#### Technology

2. Web servers
    - Easy to reach and analyze
3. Applications
    - Typically easy to obtain, analyze, decompile and search for vulnerabilities
4. Servers
5. Networks
    - Lateral movement: reconstruct the layout of the network infrastructure and move to new targets while remaining undercover and without triggering security systems
6. Operating systems

Main types:

- **Trojan**
- **Remote Access Trojan** (for remote control)
- **Injection**: unvalidated input allows to inject malicious behaviors into an application or web server
  - SQL injection
  - Cross site scripting (XSS)
  - OS command injection
  - Remote code execution
  - XML external entity injection (XXE)
- **Privilege escalation**
  - Vertical (aka privilege elevation) / horizontal
- **Brute force**
- Covert channel
  - A compromised machine in the internal network establishes a connection to a Command & Control external server 
  - The connection can also be an internal or external storage asynchronously read and written by the C&C server and the controlled machine 
- **Drive by download**
  - Use browser (or other client software) vulnerabilities to automatically install software without the user consent
- **Reflection and amplification for DoS and DDoS**
  - SYN flooding, smurfing, ...
  - Botnets controlled directly through vulnerabilities or rented from other criminals
- Insider attacks
  - Deliberated / non deliberated (incompetence or lack of knowledge) / underestimation
  - Motivations: M&S = Money & Sex, MICES = Money, Ideology, Compromise, and Ego
- **Ransomware**


Challenges:
  - Logs: logs are fundamental to find and analyze cyber attacks and expert attackers delete them. Part of the solution is to backup the logs offline.
  - Devices: Both devices, storage devices and their content should be monitored for suspicious content or behaviors
  - Shadow IT: devices in the company that cannot be tracked (and hence updated or protected)
  - Visibility: Even trusted employees should only see part of the data, to mitigate exfiltration risk

Side channel attacks use secondary untracked or unmonitored connections to the outside world or physical side-effects of operation of a system that allow to monitor/interact with the system itself. They are rare and typically used only by state actors, but they are dangerous, for example they can help violate air-gapped systems (AirHopper, Air-Fi, ...) or create a return channel for data exfiltration.

## Cybersecurity agencies

- NIST
- Agenzia per la Cybersecurity Nazionale (ACN, Italy)
- MITRE (bought by Google)
- ...
