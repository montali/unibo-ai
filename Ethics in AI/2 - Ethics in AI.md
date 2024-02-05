<!-- Slides 5_L1SartorEthicsAITrustworthyAI.pdf -->
# <ins>Ethics guidelines for trustworthy AI</ins>

Framework for trustworthy AI [published by an European Commission expert group](https://digital-strategy.ec.europa.eu/en/library/ethics-guidelines-trustworthy-ai) (critical ethics, not legally binding).

## <ins>Chapter 1 - Ethical principles</ins>

1. **Respect for human autonomy**: Humans interacting with AI systems must be able to keep full and effective self determination over themselves, and be able to partake
in the democratic process.
2. **Prevention of harm**: AI systems should neither cause nor exacerbate harm or otherwise adversely affect human beings. This entails the protection of human dignity as well as mental and physical integrity.
3. **Fairness**
    * equal and just distribution of both benefits and costs
    * individuals and groups are free from unfair bias, discrimination and stigmatization
    * Promoting equal opportunity in terms of access to education, goods, services and technology
    * Never leading to people being deceived or unjustifiably impaired in their freedom of choice
4. **Explicability**
    * processes should be transparent
    * AI system capabilities and limitations should be clearly communicated to stakeholders throughout its lifecycle, facilitating traceability and auditability
    * Decisions should be explainable to those directly and indirectly affected; if not possible, other explicability measures may be required

Particular attention must be paid to situations involving children or vulnerable groups or characterized by asymmetries of power or information.

## <ins>Chapter 2 - Key requirements</ins>

1. **Human agency and oversight**
    * The system should respect and support fundamental human rights
    * Users should be able to make informed autonomous decisions
    * Human oversight through human in the loop (HITL), human on the loop (HOTL), or human in command (HIC) and/or public controls
    * AI systems should reliably behave as intended while minimizing unintentional and unexpected harm and preventing unacceptable harm.
2. **Technical robustness and safety**
    * Security, fall back plans and general safety
    * Accuracy (ability to make correct judgments)
    * Reliability and reproducibility
3. **Privacy and data governance**
    * Respect for privacy throughout the lifecycle
    * Quality and integrity of data (no harmful biases, inaccuracies, errors and mistakes or malicious data)
4. **Transparency**
    * Traceability: datasets and processes should be documented
    * Explainability: technical processes and related human decisions should be explainable
    * Communication: Humans have the right to be informed that they are interacting with an AI system.
5. **Diversity, non-discrimination and fairness**
    * Prevent unintended (in)direct prejudice and discrimination against certain groups of people
    * Accessibility and universal design: designed in a way that allows all people to use it, regardless of their age, gender, abilities or characteristics
6. **Societal and environmental well-being**
    * Sustainability and environmental friendliness
    * Effects of on individuals, groups and society (especially on democracy) must be monitored and considered
7. **Accountability**
    * Auditability: enable Enablement of the assessment of algorithms, data and design processes
    * Minimization and reporting of negative impact
    * Trade offs should be addressed in a rational and methodological manner
    * Accessible mechanisms should be foreseen that ensure adequate redress (compensation/remediation)

-----

<!-- Slides 6_GS2021HumanRightsAI.pdf -->
# Human rights

Primary ethical demands. Examples:
* **Freedom and dignity**: All human beings are born free and equal in dignity and rights
* Right to **life, liberty and security**
* Right to **equality and nondiscrimination**
* Right to **privacy**
* Right to **property**
* Freedom of **assembly and association**
* Right to an effective remedy by tribunals for his fundamental rights
* Right to a **fair and public hearing** by an independent and impartial tribunal in the determination of his rights and obligations and of any criminal charge against him.
* **Presumption of innocence until proven guilty** according to law in a public trial at which he has had all the guarantees necessary for his defense
* Freedom of opinion, expression and information
* Right to **take part in government** (directly or through freely chosen representatives)
* Right to **social security**
* Right to **work**
* Right to **education**
* Right to **culture**

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

## AI and <ins>profiling</ins>

A profile is a set of correlated data that represents a (individual or collective) subject. AI increases the potential for profiling, namely, for **inferring information about individuals or groups**, and adopting assessments and decisions on that basis.
The information so inferred may also be conditional, that is, it may consist in the propensity to react in a certain way to given inputs, potentially leading to influence and manipulation. This may negatively affect the individuals concerned.

### The <ins>Cambridge Analytica case</ins>

In 2018 (before GDPR came into effect) about 320'000 people registered as voters in the USA were invited to take a detailed online personality/political test (about 120 questions); they also had to provide access to their Facebook profile and would be rewarded with a small amount of money (from two to five dollars). They were told that their data would only be used for the academic research.

Cambridge Analytica used the data about test-takers (FB likes, posts, ... + test answers) as a training set for building a model to profile their friends on FB, correlating the information in people's FB pages to predictions about psychology and political preferences.

Then predictions were made with the model on people who did not take the test using the data available on their FB profiles. Based on these predictions potential voters who were likely to change their voting behavior were identified and targeted with ads without making them aware of the purpose of such messages.

## <ins>Surveillance Capitalism</ins>

Some authors have taken a positive view of the development of systems based on
the massive collection of information, as integration of AI and Big Data enables increased efficiency. Recording data from economic transactions to construct user profiles allows to personalize interactions with users.

**Polanyi’s three fictional commodities: land, labor, and money**. The dynamics of capitalism produces destructive tensions (exploitation, destruction
of environment, financial crises) unless countervailing forces (law, politics and social organizations), intervene to counteract, moderate and mitigate excesses.

**Fourth fictional commodity: human experience**. Surveillance capitalism turns human experience into recorded and analyzed behavior and marketable opportunities to anticipate and influence. Individuals can be subject to manipulation, deprived of control over their future and made unable to develop their individuality. Adeguate legal, political and social measures have not yet being developed (EU's GDPR and California CCPA are only a first step).

Similar risks are posed by surveillance states (see for example the Chinese Social credit systems).

## Differential treatment and AI bias

In use cases like usage of health data (or health predictions based on profiling) for insurance evaluation, individuals who already are disadvantaged because of their medical conditions would suffer further disadvantage, being excluded from insurance or being subject to less favorable conditions.

AI enables automated decision-making in domains that require complex choices, based on multiple factors and on non-predefined criteria.

**<ins>Disparate decision</ins>**: Using prohibited/biased features (race, ethnicity, gender, ...) in AI models

**<ins>Disparate impact</ins>**: Not using prohibited/biased features but getting a biased outcome or disproportionally effecting certain groups because (knowingly or not)
* using features that are correlated with prohibited/biased features
* using biased training data
* using unbalanced training data
* under-representation in the dataset of a group 

In many cases, the best solution is enabling the affected individuals to request a human review of an automated decision as well as by favouring transparency.

-----

<!-- Slides 10_Fairness.pdf -->
# Fairness in algorithmic decision

* Equal and just distribution of benefits and costs
* Individuals and groups free from unfair bias, discrimination and stigmatization
* AI decision making: informational fairness + content fairness of inferences

### <ins>COMPAS</ins> and the Lomis case

Correctional Offender Management Profiling for Alternative Sanctions (COMPAS) is a decision support software to determine the risk of recidivism and appropriate correctional treatment, based on statistical algorithms.
Input: 137-question multiple-choice test, prior criminal history, education, drug abuse, employment status, ... .
Output: classification to low/medium/high risk.

In 2013 E. Loomis was charged with driving a stolen vehicle and fleeing from police. The investigation that included the COMPAS risk assessment, he was classified at high risk for recidivism and sentenced to 6 years imprisonment.
The decision was appealed by Loomis for violation of due process rights, COMPAS discriminating on race and violation to the right to individualized decision.
In 2016 the Supreme Court of Wisconsin rejected all defendant’s arguments:
* Statistical algorithms do not violate the right to individualized decisions if used to enhance a judge's evaluation of other evidence in the formulation of an individualized sentencing
* The prohibition to base decisions solely on risk scores and the obligation to motivate are safeguards of the defendant’ rights
* Considering gender is necessary to achieve statistical accuracy
* Judges should be informed on the debate concerning COMPAS race discrimination

In 2016 ProPublica evaluated the accuracy and fairness of COMPASS on 11'757 defendants:
* Moderate-Low Predictive accuracy (61.2%)
* Black defendants were predicted at a higher risk than they actually
were (probability of high-risk misclassification: 45% blacks vs. 23% whites)
* White defendants were often predicted to be less risky than they were (probability of low-risk misclassification: 48% whites vs. 28% blacks).

Taking 2000 defendants divided in two 1000-people groups with similar characteristics, using COMPAS and applying the SAPMOC model for evaluating fairness yields these results:
* **Statistical parity**: Each group should have an equal proportion of positives and negatives predictions (COMPAS fails)
* **Equality of opportunity**: The members of each group, which share the same features, should be treated equally in equal proportion (COMPAS fails)
* **Calibration**: The proportion of correct predictions should be equal within each group and with regard to each class (COMPAS succeeds)
* **False rate / Conditional use error**: The proportion between FP (FN) and the total amount of positive (negatives) predictions should be equal for the 2 groups (COMPAS succeeds)
* **Treatment equality**: The ratio between errors in positive and negative predictions should be equal in all groups (COMPAS fails)

-----

<!-- ethics_filtering.pdf -->
# Filtering and moderation

Moderation is the active governance of platforms with user-generated content to
* **prevent unlawful and harmful behavior** and mitigate its effect
* **facilitate cooperation**
* **prevent abuse**

Possible classifications:
* Where
  * **centralized**: applied by a central authority
  * **decentralized**: multiple distributed moderators, operating with a degree of independence
* Why
  * **uniform policy** on the whole platform
  * **multiple policies** on subsets of the platform
* When
  * **ex-ante**: applied before the content made publicly available
  * **ex-post**: applied after the content is already available
    * reactive: examined after the issue has been reported by users or third parties
    * proactive: examined upon initiative of the moderation system
* How
  * **transparent**: provides information on actions taken
    * contestable
    * non-contestable
  * **secret**: does not provide any information about the operation
* Who
  * **manual**
  * **automated**
  * **hybrid**: combination of humans and automated tools

[<ins>Santa Clara principles</ins>](https://santaclaraprinciples.org/) proposes guidelines for companies:
* numbers of posts removed and accounts suspended or removed should be public
* users affected should be notified with the reason of the action
* users affected should be able to appeal

Important social issues to address in filtering and moderation:
* freedom of expression and over-blocking
* liability: Platforms might be obligated to follow some local laws, however the process of defining what content should be filtered and the associated legal ramifications can be challenging
* filter bubbles
* echo chambers
* censorship
* fake news
* bias and discrimination
* cultural, regional and contextual sensitivity differences

-----

<!-- The regulation of online targeted advertising.pdf -->
# Targeted Behavioral Advertising

Technique in which data about the user (search queries, browsing history, etc.) is collected and analyzed to tailor advertisements to individuals based on their online behavior.

Legal issues:
* **Data Protection and Privacy**: collection and processing of personal data raises concerns about privacy and data protection and requires compliance with data protection laws (GDPR for EU)
* **Consent and Opt-Out** Mechanism: GDPR requires obtaining valid consent from users (freely given, specific, informed and unambiguous)
* **Children’s Privacy**: targeted advertising involving children requires special attention (ex. from GDPR)

Ethical issues:
* **User privacy and Autonomy**: User autonomy and transparency and control over data usage should be respected by informing the user about what data is collected and how it's used
* **Manipulation and Persuasion**: potential manipulation and exploitation of individuals' behaviors and vulnerabilities for commercial gains
* **Discrimination and Unfairness**: possible discrimination or reinforcement of existing biases since it could exclude groups from opportunities based on sensitive characteristics (race, gender,etc.)

[**Digital Services Act** (DSA) and the **Digital Market Act** (DMA)](https://digital-strategy.ec.europa.eu/en/policies/digital-services-act-package) regulate among other things TBA:
* **Transparency**: DSA requires online platforms to provide clear and understandable information to users about advertising practices, including personalized advertising.
* **User Control and Consent**: DSA requires platforms to provide users with effective opt-out mechanisms for personalized advertising and the ability to make informed choices about their data
* **Accountability and Compliance**: Both DSA and DMA require platforms to conduct impact assessments, address risks of discriminatory practices and ensure compliance with data protection rules