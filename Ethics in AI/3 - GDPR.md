<!-- Slides 8_AI_GDPR03InGDPR_FL_short2022.pdf -->
# GDPR

The European Union **<ins>General Data Protection Regulation (GDPR)</ins>** is focused on data protection challenges emerging for the Internet and it does not contain the term "Artificial Intelligence", but it's relevant for AI.

### <ins>Article 4 - Definitions</ins>

* **<ins>personal data</ins>**: any information relating to an identified or identifiable natural person ("**<ins>data subject</ins>**"), who can be identified **directly or indirectly**
  * Pseudonymisation: data items that identify a person are substituted with a pseudonym, but the link between the pseudonym and the identifying data items can be retraced by using separate info. **Pseudonymised data still are personal data**.
  * If technological developments make it possible to turn anonymised data into personal data (re-identification), such data are to be treated as personal data,
  * it is not necessary that the data subject is identified with absolute certainty; a degree of probability may be sufficient
  * AI systems may infer new information about data subjects. According to the ECJ, only the data on which the analysis was based as well as the final conclusion of the analysis were to be regarded as personal.
* **<ins>processing</ins>**: any operation or set of operations which is performed on personal data or on sets of personal data, **whether or not by automated means**
* **<ins>controller</ins>**: the natural or legal person, public authority, agency or other body which, alone or jointly with others, determines the purposes and means of the processing of personal data
* **<ins>processor</ins>**: a natural or legal person, public authority, agency or other body which processes personal data on behalf of the controller
* **<ins>profiling</ins>**: automated processing of personal data to evaluate certain personal aspects relating to a natural person. Since inferred data concerning individuals also are personal data under the GDPR data protection rights should in principle also apply.
* **<ins>consent</ins>** of the data subject: **freely given, specific, informed and unambiguous** indication of the data subject's wishes by which he or she, by a statement or by a clear affirmative action, signifies agreement to the processing of personal data relating to him or her

### <ins>Article 3 - Territorial scope</ins>

GDPR applies to the **processing of personal data**:
* in the context of tha activities of an establishment of a **controller or a processor in the Union**, regardless of whether the processing takes place in the Union or not
* of **data subjects who are in the Union** by a controller or processor not established in the Union

### <ins>Article 5 - Principles</ins>

* Lawfulness, fairness and transparency
* Purpose limitation
* Data minimization
* Data accuracy
* Storage limitation
* Integrity and confidentiality
* Accountability principle

### <ins>Article 6 - Lawfulness of processing</ins>

Processing shall be lawful only if and to the extent that at least one of the following **legal bases** applies:
* the data subject has given **consent** to the processing of his or her personal data for one or more **specific purposes**;
* processing is **necessary for the performance of a contract** to which the data subject is party or in order to take steps at the request of the data subject prior to entering into a contract;
* processing is **necessary for compliance with a legal obligation** to which the controller is subject;
* processing is **necessary in order to protect the vital interests** of the data subject or of another natural person;
* processing is **necessary for the performance of a task carried out in the public interest** or in the exercise of official authority vested in the controller;
* processing is **necessary for the purposes of the legitimate interests pursued by the controller or by a third party**, except where such interests are overridden by the interests or fundamental rights and freedoms of the data subject which require protection of personal data, in particular where the data subject is a child.

### <ins>Article 7 - Conditions for consent</ins>
* Where processing is based on consent, **the controller shall be able to demonstrate that the data subject has consented** to processing of his or her personal data.
* If the data subject's consent is given in the context of a written declaration which also concerns other matters, the **request for consent shall be presented in a manner which is clearly distinguishable from the other matters**, in an intelligible and easily accessible form, using clear and plain language. Any part of such a declaration which constitutes an infringement of this Regulation shall not be binding.
* **The data subject shall have the right to withdraw his or her consent at any time**. The withdrawal of consent shall not affect the lawfulness of processing based on consent before its withdrawal. Prior to giving consent, the data subject shall be informed thereof. It shall be as easy to withdraw as to give consent.
* When assessing whether consent is freely given, utmost account shall be taken of whether, inter alia, the performance of a contract, including the provision of a service, is conditional on consent to the processing of personal data that is not necessary for the performance of that contract.

### <ins>Article 13 and 14 - Information on automated decision making</ins>
The controller has the **obligation to provide**:
* information on the **existence of automated decision-making**, including profiling
* meaningful information about the **logic involved**, as well as the significance and the envisaged consequences of such processing for the data subject

The most basic information about the decision system would be:
* The **input data**
* Whether different data items are favoring or disfavoring the outcome
* The **target values** that the system is meant to compute
* The **envisaged consequence** of the automated assessment/decision

With AI models this might require **explainable AI** for
* **model explanation**: global explanation of the model
* **model inspection**: representation of specific properties of the model
* **outcome explanation**: account of the outcome of the model given some specific inputs

Explanation techniques include:
* **Contrastive explanation**: what input values made the difference in a decision
* **Selective explanation**: most relevant factors
* **Causal explanation**: focus on causes rather than mere statistical correlations
* **Social explanation**: tailoring of information for the recipient comprehension capacities

### <ins>Article 17 - Right to erasure / right to be forgotten</ins>
The controller shall have the obligation to erase personal data without undue delay where one of the following grounds applies:
* the personal data are **no longer necessary** in relation to the purposes for which they were collected or otherwise processed
* the **data subject withdraws consent** on which the processing is based
* the **data subject objects to the processing** and there are no overriding legitimate grounds for the processing
* the personal data have been **unlawfully processed**

### <ins>Article 22 - Automated individual decision-making</ins>
The data subject shall have the right **not to be subject** (not only to object!) **to a decision based solely on automated processing, including profiling, which produces legal effects** concerning him or her or similarly significantly affects him or her.
Necessary conditions for the application of this article:
* A decision that has legal or anyway significant effect must be taken
* It must be **solely** based on automated processing
* It must include profiling
* The automated decision is not necessary for the performance of a contract between subject and controller (example: a human decision does not require an unreasonable long time)
* The subject has not given explicit consent

The data subject does not need to invoke specific grounds when objecting to processing for direct marketing purposes, this is particularly significant for the self-protection of data subjects.

### <ins>Article 32 - Security of processing</ins>

The processor shall implement appropriate technical and organizational measures to ensure a level of security appropriate to the risk, including as appropriate:
* the pseudonymization and encryption of personal data
* the ability to ensure the ongoing confidentiality, integrity, availability
and resilience of processing systems and services
* the ability to restore the availability and access to personal data in a
timely manner in the event of a physical or technical incident
* a process for regularly testing, assessing and evaluating the
effectiveness of technical and organizational measures for ensuring the
security of the processing

-----

<!-- Slides 9_Claudette_AI and Ethics_2022.pdf -->
# <ins>Claudette</ins>

http://claudette.eui.eu/ , AI-based **citizen empowering technology** to automatically extract, categorizing and **summarizing information from Terms of Services and Privacy Policies**. Assists users in processing and understanding their contents, automatically **detecting potentially unfair clauses**.

Potentially unfair clauses:
* the consumer is bound by the Terms of Service simply by visiting the website or by downloading the app
* the consumer consents to the privacy policy simply by using the service
* the provider will never be liable for any action taken by other people or damages incurred by the computer because of malware
* arbitration is mandatory before the case can go to court and should take place in a state other then the state of consumer’s residence

Clearly unfair clauses:
* any judicial proceeding takes a residence away (i.e. in a different country chosen by the provider)
* the provider will never be liable for physical injuries (health/life), gross negligence or intentional damage
* arbitration is not fully optional before the case can go to court

**Detection + Sentence classification (8 possibile unfair clause types)** model trained on a corpus of over 100 manually annotated ToS. On average more than 80% of potentially unfair clauses is found.

### GDPR expansion

Multilingual expansion with extra checks on Privacy Policies for GDPR compliance:
* **Comprehensiveness of information**: should contain all the information required by [articles 13 and 14 of the GDPR](#article-13-and-14---information-on-automated-decision-making), for example:
  * purposes of the processing for which the personal data are intended
  * Categories of personal data concerned
* **Clarity of expression**: should be framed in an understandable and precise language. Example of violations:
  * Conditional Terms: The performance of a stated action or activity
is dependent on a variable trigger
  * Generalization: terms that vaguely abstract information practices using contexts that are unclear (ex. typically, generally, ...)
  * Modality: modal verbs, adverbs and non specific adjectives, which create uncertainty with respect to actual action (ex. may, might, ...)
  * Non specific Numeric quantifiers: creates ambiguity as to the actual measure (ex. certain, some, ...)
* **Substantive compliance**: should only allow for processing of personal data compliant with the GDPR. Example of violation:
  * Notice of policy change is not given or given but without requiring a new consent
