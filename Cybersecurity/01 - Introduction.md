# Cybersecurity - Introduction

1 + 3 phase approach:

1.	Identification of the perimeter and resources to protect, resources available, constraints, …

Step 2-3-4 (cycle): 

2.	Prevention: should take 80% of the time, but we can’t prevent everything
3.	Detection: 
4.	Response: If our service runs 24/7 on person isn’t enough, someone should be always ready to triage the detected anomaly, mitigate the damage

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

## Potential damage types

- Compromise the data
- Unavailability of the service/data
- Fraud
- Data exfiltration
- Loss of credibility
- Extortion: ex. Ransomware, currently the highest risk as it’s the easiest to perform and most scalable as you are not focused on a particular target but simply find any vulnerability

Every organization has its own structure and priorities and should act differently to improve its security posture. There is no single simple solution to solve all security problems, even though some salespeople think so.

One of the first tasks to improve security is to analyze potential damages and prioritize resources to defend from threats based on the damage each threat can cause.

## Threat types

- Internal / Supply chain / External human / External natural
- Intentional / Accidental

Focusing on human made threats we can also distinguish:

### Threat actor
Type of human perpetrator
- Motivated by money (vast majority)
  - nation state actors
    - most dangerous
    - espionage, sabotage, social control
    - handled by homeland security, intelligence (e.g. CIA, NSA), army
    - mainly interested in critical infrastructures: energy, finance, healthcare, water (plus their suppliers!)
  - advanced persistent threats (APT)
    - sophisticated targeted attacks on extended periods of time by professional attackers with significant resources
    - sometimes used as proxy by states or tolerated by states as long as they operate only non-friendly states
    - highly difficult to attribute and find links with states
  - criminals
    - not the most dangerous but the most likely for most organizations
    - target types
      - looking for "low hanging fuits" (many attacks with low payoff, for example small-medium enterprises)
      - looking for top targets (few attacks with high payoff, for example 1B+ companies)
    - vertically specialized competencies, trading results in criminal marketplaces and with data brokers selling the data for profit
    - beyond actors, includes facilitators (money laundering, ...) and criminal marketplace managers
    - some offer their competencies as a service, including assistance to customers
  - specialized companies
    - malware/exploit vendors, data brokers
    - usually they claim to work only for law enforcement, but even assuming this is true it's not necessarily always ethical
  - competitors
  - ex employees
- Motivated by ideology
  - people fighting for an ideology (e.g. Anonymous)
  - script kiddies
  - pathological criminals (e.g. trying to spy on ex partners)

### Threat vector
The means by which an actor executes the attack


