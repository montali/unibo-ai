# Ethics in Artificial Intelligence

<!-- Slides 0_L2SartorEthicsIntro.pdf -->

### Positive vs Critical morality
**<u>Positive (conventional) morality</u>**: the moral rules and principles that are accepted in a society. "Positive" in this context does not necessarily mean that it's good but that it's actually in use and applied in the real world

**<u>Critical morality</u>**: The morality that is correct, rational, just (maybe since considers all individual and social interests at stake giving each one the due significance). We can criticize positive morality based on our critical morality: we may be right or wrong.
### Normative ethics vs Meta-ethics
**<u>Normative ethics</u>** is concerned with determining what is morally required, how one ought to behave

**<u>Meta-ethics</u>** is concerned with is the study of the nature, scope, and meaning of moral judgement
### Absolutism vs Relativism
**<u>Absolutism</u>**: There is a single true ethics: when two people express incompatible ethical judgement one of them must be wrong

**<u>Relativism</u>**: Ethical judgments are always relative to particular frameworks of attitudes

<!-- Prima facie duties are discussed later -->

### Morality and other normative systems
Morality may coincide, be enforced by or be against law, religion, tradition and/or self-interest.

-----
<!-- Slides 1_L2SartorEthicsConsequentilism.pdf -->

# <u>Consequentialism</u>
Thinks morality as an optimization problem to **get the global highest utility**. An action is morally required if and only if
* it delivers the best outcome, relative to its alternatives
* its good outcomes outweigh its negative outcomes to the largest extent
* it produces the highest utility

Various kinds (what is included in utility calculation and how?):
## <u>Utilitarianism</u>
**Mill’s principle of utility**: Actions are **right in proportion as they tend to promote happiness**, wrong as they tend to produce the reverse of happiness. By happiness is intended pleasure, and the absence of pain; by unhappiness, pain, and the privation of pleasure.
* Conceptually simple
* Egalitarian (everybody’s utility counts in the same way)
* Fits with some basic intuitions (making people happy is good, making them suffer is bad)
* In many case it is workable, in some cases problematic (what should we do about hunger, how shall we treat friends and relatives, etc.)

Utilitarianism favors (modest) redistribution of wealth, since the same amount of money gives more utility to the poor than to the rich. The impact of redistribution on wealth generation however has to be considered. Wealth maximization (adopted by some economic approach) aims at maximizing the wealth in society regardless of distribution, going in contrast with utilitarianism.
### <u>Act utilitarianism</u>
Do the **action that maximizes utility**.
* Can individuals, or even AI systems, accurately calculate and optimize the outcomes of their actions? The availability of information for such calculations may be limited.
* Should I give to the poor all that I have above the minimum that allows me to survive?
* Should I give the same importance to everybody, regardless of their connection to me?
* Is it OK to harm some people for the greater benefit of others? (Reprisals? Torture? Sadism?)
### <u>Rule utilitarianism</u>
Follow a **social rule the general compliance with which would provide the highest utility**.
* What about those exceptional cases in which the rule does not deliver?
* What if you know that most people are not following the rule? Should we be honest if most people around as are dishonest?
# Social dilemmas
## <u>Trolley problem</u>
* Standard: should you switch “the switch” to divert a train from a rail branch where it would kill many people to a branch where it would kill only one?
* Variant with no switch but ability to sacrifice someone (“the fat man”) pushing him on the rail to stop the train before hitting the others

## The social dilemma of autonomous vehicles
* Should a car divert and kill someone on a sidewalk to save many on the road?
    * What if people is illegally crossing with a red light? In utilitarianism this would be irrelevant as we only consider global utility 
* Should a car divert and kill its passenger to save someone on the road?
* Should a car divert and kill its passenger to save many on the road?
* In utilitarianism yes, but a human driver would probably not do that

## The surgeon case by Judith Jarvis Thomson
Each of five patients are in need of a different organ, each of whom will die without that organ, but none is available. A traveler passes by the hospital and its disappearance would not be noted by anyone. Should the surgeon kill him to gather organs and save other patients?
* Act utilitarianism would say yes, but the morality of this is questionable
* In rule utilitarianism this would be partially solved as acting like this would make people stay away from hospitals and make life harder for everybody.

-----
<!-- Slides 2_SartorEthicsIntroDeontology.pdf -->

# <u>Deontology</u>
Certain actions are good or bad regardless of their consequences: what makes a choice right is its **conformity with a moral norm** which order or permits it, rather than its good of bad effect.

Issue: Is it considered unethical to have preferences for oneself or one’s friends? The **<u>Golden Rule</u>** is often invoked as a guideline for ethical behavior (however its complex to apply it universally):
* **Treat others as you would like others to treat you**
* **Do not treat others in ways that you would not like to be treated**
* **What you wish upon others, you wish upon yourself**

## Kantian ethics
**<u>Hypothetical imperatives</u>**: Moral guidelines that require us to do **what fits our personal goals** or desires.

**<u>Categorical imperative</u>**: moral guideline that moral principle that **applies universally to all rational beings**, regardless of personal wants and desires.

**Kant**’s first formulation of the categorical imperative is the **<u>principle of universalizability</u>**: "**Act only according to that maxim by which you can at the same time will that it should become a universal law**".
A maxim is a subjective principle of action, an intention to perform an action for a certain reason.
**Landau’s test of universalizability**:
1. Formulate your maxim clearly state what you intend to do, and why you intend to do it.
2. Imagine a world in which everyone supports and acts on your maxim.
3. Then ask: Can the goal of my action be achieved in such a world?

An alternative formulation of the categorical imperative is the **<u>principle of humanity</u>**: "so act that you treat humanity in your own person and in the person of everyone else always at the same time as an end and never merely as means". Rational beings capable of morality have a **dignity** and should **never be treated as mere means to an end**, without considering their values and purposes.

For Kant if we follow rationality, we have to be moral:
1. If you are rational, then you are consistent.
2. If you are consistent, then you obey the principle of universalizability.
3. If you obey the principle of universalizability, then you act morally.
4. Therefore, if you are rational, then you act morally.
5. Therefore, if you act immorally, then you are irrational.

A robot based on Kantian ethics would be consistent and impartial but may cat on bad or too rigid maxims.

## Prima facie duties

**<u>Pro-tanto moral judgment</u>**: Many moral prescription are defeasible. They state general propositions that are susceptible of exceptions. For example: we should no lie, but what if a lie would save a person’s life?

Ross' **<u>Prima facie duties</u>**: rules we should follow because there is a moral reason in favor of doing the act, but one that can be outweighed by other (moral) reasons:
* **Fidelity**: We should strive to keep promises and be honest and truthful.
* **Reparation**: We should make amends when we have wronged someone else.
* **Gratitude**: We should be grateful to others when they perform actions that benefit us and we should try to return the favour.
* **Non injury (or non maleficence)**: We should refrain from harming others either physically or psychologically.
* **Beneficence**: We should be kind to others and to try to improve their health, wisdom, security, happiness, and well being.
* **Self improvement**: We should strive to improve our own health, wisdom, security, happiness, and well being.
* **Justice**: We should try to be fair and try to distribute benefits and burdens equably and evenly.

# Contractarianism

### Social contract theories
**In political theory** a societal arrangement is just if it has been (or would have been) accepted by free and rational people.
**In moral theory (Shafer-Landau)** actions are morally right just because they are permitted by rules that free, equal, and rational people would agree to live by, on the condition that others obey these rules as well.

**Rawls' theory of justice**: to ensue that social contracts are fair people should choose them under a "**veil of ignorance**" as if they didn't know their gender, social position interests talents, wealth, race, etc. Two principles should be applied:
1. (with priority) Each person has an equal indefeasible claim to a fully adequate scheme of equal basic liberties, compatible with the same liberties for all. This includes freedom of conscience, freedom of association, freedom of speech, liberty of the person, and the right to vote, ...
2. Social and economic inequalities are permissible only if they meet two conditions. First, they must be attached to offices and positions that are open to all under fair equality of opportunity. Second, they must work to the greatest benefit of the least-advantaged members of society, known as the difference principle.

**Habermas' Discourse Ethics**: A **rule of action or choice is justified**, and thus valid, **only if all those affected by the rule or choice could accept it in a reasonable discourse**.
A norm is valid when the foreseeable consequences and side effects of its general observance for the interests and value orientations of each individual could be jointly accepted by all concerned without coercion.

# Virtue ethics

Ethics should not focus on norms nor on consequences. An act is morally right just because it is one that a virtuous person. The right act is that that would result from the mix of the relevant virtues: honesty; loyalty; courage; impartiality, wisdom, fidelity, generosity, compassion, etc.

-----
<!-- Slides 3_GS2012SlidesGameTheoryLaw2.pdf -->

# Game theory

<!-- TODO -->

-----
<!-- Slides 7_AI_GDPR02AIPersonalData_FL_2022.pdf -->

# AI and Big Data risks

AI can be misused to pursue economic interests in ways that are harmful to individuals and society:
* **Eliminate or devalue the jobs** of those who can be replaced by machines
* **Concentrating wealth** and favour economic models in which "the winner takes all"
* New opportunities for **illegal activities** (cyber attacks, fraud, ...)
* Pervasive **surveillance** (massive collection of personal data about individuals)
* **Manipulation** (pervasive influence on the behavior of individuals using **fake news** or other means)
  
Governments can misuse AI to anticipate and control citizens' behavior and **restrict individual liberties**.

## AI and <u>profiling</u>

A profile is a set of correlated data that represents a (individual or collective) subject. AI increases the potential for profiling, namely, for **inferring information about individuals or groups**, and adopting assessments and decisions on that basis.
The information so inferred may also be conditional, that is, it may consist in the propensity to react in a certain way to given inputs, potentially leading to influence and manipulation. This may negatively affect the individuals concerned.

### The <u>Cambridge Analytica case</u>

About 320'000 people registered as voters in the USA were invited to take a detailed online personality/political test (about 120 questions); they also had to provide access to their Facebook profile and would be rewarded with a small amount of money (from two to five dollars). They were told that their data would only be used for the academic research.

Cambridge Analytica used the data about test-takers (FB likes, posts, ... + test answers) as a training set for building a model to profile their friends on FB, correlating the information in people's FB pages to predictions about psychology and political preferences.

Then predictions were made with the model on people who did not take the test using the data available on their FB profiles. Based on these predictions potential voters who were likely to change their voting behavior were identified and targeted with ads without making them aware of the purpose of such messages.

## <u>Surveillance Capitalism</u>

Some authors have taken a positive view of the development of systems based on
the massive collection of information, as integration of AI and Big Data enables increased efficiency. Recording data from economic transactions to construct user profiles allows to personalize interactions with users.

**Polanyi’s three fictional commodities: land, labor, and money**. The dynamics of capitalism produces destructive tensions (exploitation, destruction
of environment, financial crises) unless countervailing forces (law, politics and social organizations), intervene to counteract, moderate and mitigate excesses.

**Fourth fictional commodity: human experience**. Surveillance capitalism turns human experience into recorded and analyzed behavior and marketable opportunities to anticipate and influence. Individuals can be subject to manipulation, deprived of control over their future and made unable to develop their individuality. Adeguate legal, political and social measures have not yet being developed (EU's GDPR and California CCPA are only a first step).

Similar risks are posed by surveillance states (see for example the Chinese Social credit systems).

## Differential treatment and AI bias

In use cases like usage of health data (or health predictions based on profiling) for insurance evaluation, individuals who already are disadvantaged because of their medical conditions would suffer further disadvantage, being excluded from insurance or being subject to less favorable conditions.

AI enables automated decision-making in domains that require complex choices, based on multiple factors and on non-predefined criteria.

**<u>Disparate decision</u>**: Using prohibited/biased features (race, ethnicity, gender, ...) in AI models

**<u>Disparate impact</u>**: Not using prohibited/biased features but getting a biased outcome or disproportionally effecting certain groups because (knowingly or not)
* using features that are correlated with prohibited/biased features
* using biased training data
* using unbalanced training data
* under-representation in the dataset of a group 

In many cases, the best solution is enabling the affected individuals to request a human review of an automated decision as well as by favouring transparency.

-----
<!-- Slides 8_AI_GDPR03InGDPR_FL_short2022.pdf -->

# GDPR

The European Union **<u>General Data Protection Regulation (GDPR)</u>** is focused on data protection challenges emerging for the Internet and it does not contain the term "Artificial Intelligence", but it's relevant for AI.

### <u>Article 4 - Definitions</u>

* **<u>personal data</u>**: any information relating to an identified or identifiable natural person ("**<u>data subject</u>**"), who can be identified **directly or indirectly**
  * Pseudonymisation: data items that identify a person are substituted with a pseudonym, but the link between the pseudonym and the identifying data items can be retraced by using separate info. **Pseudonymised data still are personal data**.
  * If technological developments make it possible to turn anonymised data into personal data (re-identification), such data are to be treated as personal data,
  * it is not necessary that the data subject is identified with absolute certainty; a degree of probability may be sufficient
  * AI systems may infer new information about data subjects. According to the ECJ, only the data on which the analysis was based as well as the final conclusion of the analysis were to be regarded as personal.
* **<u>processing</u>**: any operation or set of operations which is performed on personal data or on sets of personal data, **whether or not by automated means**
* **<u>controller</u>**: the natural or legal person, public authority, agency or other body which, alone or jointly with others, determines the purposes and means of the processing of personal data
* **<u>processor</u>**: a natural or legal person, public authority, agency or other body which processes personal data on behalf of the controller
* **<u>profiling</u>**: automated processing of personal data to evaluate certain personal aspects relating to a natural person. Since inferred data concerning individuals also are personal data under the GDPR data protection rights should in principle also apply.
* **<u>consent</u>** of the data subject: **freely given, specific, informed and unambiguous** indication of the data subject's wishes by which he or she, by a statement or by a clear affirmative action, signifies agreement to the processing of personal data relating to him or her

### <u>Article 3 - Territorial scope</u>

GDPR applies to the **processing of personal data**:
* in the context of tha activities of an establishment of a **controller or a processor in the Union**, regardless of whether the processing takes place in the Union or not
* of **data subjects who are in the Union** by a controller or processor not established in the Union

### <u>Article 5 - Principles</u>

* Lawfulness, fairness and transparency
* Purpose limitation
* Data minimization
* Data accuracy
* Storage limitation
* Integrity and confidentiality
* Accountability principle

### <u>Article 6 - Lawfulness of processing</u>

Processing shall be lawful only if and to the extent that at least one of the following **legal bases** applies:
* the data subject has given **consent** to the processing of his or her personal data for one or more **specific purposes**;
* processing is **necessary for the performance of a contract** to which the data subject is party or in order to take steps at the request of the data subject prior to entering into a contract;
* processing is **necessary for compliance with a legal obligation** to which the controller is subject;
* processing is **necessary in order to protect the vital interests** of the data subject or of another natural person;
* processing is **necessary for the performance of a task carried out in the public interest** or in the exercise of official authority vested in the controller;
* processing is **necessary for the purposes of the legitimate interests pursued by the controller or by a third party**, except where such interests are overridden by the interests or fundamental rights and freedoms of the data subject which require protection of personal data, in particular where the data subject is a child.

### <u>Article 7 - Conditions for consent</u>
* Where processing is based on consent, **the controller shall be able to demonstrate that the data subject has consented** to processing of his or her personal data.
* If the data subject's consent is given in the context of a written declaration which also concerns other matters, the **request for consent shall be presented in a manner which is clearly distinguishable from the other matters**, in an intelligible and easily accessible form, using clear and plain language. Any part of such a declaration which constitutes an infringement of this Regulation shall not be binding.
* **The data subject shall have the right to withdraw his or her consent at any time**. The withdrawal of consent shall not affect the lawfulness of processing based on consent before its withdrawal. Prior to giving consent, the data subject shall be informed thereof. It shall be as easy to withdraw as to give consent.
* When assessing whether consent is freely given, utmost account shall be taken of whether, inter alia, the performance of a contract, including the provision of a service, is conditional on consent to the processing of personal data that is not necessary for the performance of that contract.

### <u>Article 13 and 14 - Information on automated decision making</u>
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

### <u>Article 17 - Right to erasure / right to be forgotten</u>
The controller shall have the obligation to erase personal data without undue delay where one of the following grounds applies:
* the personal data are **no longer necessary** in relation to the purposes for which they were collected or otherwise processed
* the **data subject withdraws consent** on which the processing is based
* the **data subject objects to the processing** and there are no overriding legitimate grounds for the processing
* the personal data have been **unlawfully processed**

### <u>Article 22 - Automated individual decision-making</u>
The data subject shall have the right **not to be subject** (not only to object!) **to a decision based solely on automated processing, including profiling, which produces legal effects** concerning him or her or similarly significantly affects him or her.
Necessary conditions for the application of this article:
* A decision that has legal or anyway significant effect must be taken
* It must be **solely** based on automated processing
* It must include profiling
* The automated decision is not necessary for the performance of a contract between subject and controller (example: a human decision does not require an unreasonable long time)
* The subject has not given explicit consent

The data subject does not need to invoke specific grounds when objecting to processing for direct marketing purposes, this is particularly significant for the self-protection of data subjects.

### <u>Article 32 - Security of processing</u>

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

# <u>Claudette</u>

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
