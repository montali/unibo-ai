# The neural code

Before allowing anything else to be said, a small **recap**: the level of interdisciplinarity in Cognitive Neuroscience is a crucial element. We're intersecting several aspects that need to be integrated to build up this discipline. It puts together neuroscience and cognitive science, to show us how the brain structure is set up to serve our cognitive function. Integrating these two has been the main challenge between the 50s and 60s. It is important to consider the advances that permitted this. The development of technology has been crucial: for example, *Transcranial Magnetics Stimulation*, or *Functional Magnetic Resonance Imaging*, *Human Electroencephalography* and lots of other diagnostical instruments.

Why do we have two brains? Different parts get specialized in different tasks. Interestingly, we don't have answers: the reason of this duality is unclear.

## Complexity

Brain size and evolution. How are they linked? What is the brain made of?

The body size vs brain size is an index of complexity, relatable to the level of computations that the brain can make. We have higher functions that we can use to adapt flexibly to the environment. The understanding of this machinery, is trying to understand how the brain is made of? How could we reproduce something similar?

An artificial neural network tries to reproduce some patterns that emerged from real brains: nodes -> neurons. These are artificial systems that mimic what is happening in the brain in a certain way, deploying some functions that can be used in other contexts. 

## Neurons

Neurons have been defined in 1890 as a discrete nerve cell, and it represents the primary computational unit of the nervous system. What weblike to do is treating it accordingly to the neuron hypothesis/dogma, to understand communication and cognition through communication between neurons. A crucial step is going into the basics of **what a neuron is**.

Our body is composed of trillions of cells, wach of them is enclosed by a **membrane**. Neurons are cells, responsible for rapid communication between sensor cells (like the *retina*), muscle cells, and the brain (the central organizer of these interactions). We're talking about complex systems: approximately a 100 billion neurons in the brain. Cells are much alike other cells, though there are some differences: they are specialized in seinding and receiving messages. This is clearly the case in which the input/outputs are electrochemical. Think about this as a starting piont, in which we have electrochemical interaction between neurons, exchanging informations between the perifery and the brain. We have 3 different types: *sensory neurons* (generally, from the perifery to the central nervous system), *motor neurons* (the inverse) and *interneurons* (which are located into the central nervous system). An artificial NN would be this last one type. 

Interneurons can be local (they can serve to further elaborate the sensory input) or they can serve as relay (connecting local neurons). They are essential to tasks such as perceving, learning, remembering, deciding, controlling compolex behaviours. They process informations in a really complex way. This organization can serve several functions, like the *local organization*, in which we have clusters of neurons that process the input, having different interconnected clusters. This is reflected into the way they are anatomically organized. We have 3 anatomical types: *bipolars* (usually sensory, like the one we see in the slides, having 1 axon and 1 dendritic tree), *unipolar* and *multipolar*. 

Dendrites receive informations, and they are covered in synapses (all the things we see are covered in synapses, actually). They are all the potential connections that each neuron has with other neurons. These are the places in which the neuron can receive informations. Their function is crucial, they can grow and enhance the more they are used. This is connected with the plasticity of the brain. The membrane under the synapse is what is called the synaptic cleft. Most dendrites have a spine, where the two neurons actuallyy connect. When we talk about neuron dendrites, that's where synaptic plasticity happens: learning changes the **actual anatomy** of the dendritic spines! They try to connect and communicate more efficiently with other nuerons: the connections continually change, with deletion of old ones and creation of new ones. The spine density underlies many behaviours, like memory and learning. For example it's well known that if you're learning piano at a very young age it may help to keep the behaviour of the two hands relatively independent, up to a point in which you can play with the two hands without them interferring with each other. 12 years olds are already too old to play the piano. Fuck them. 

Things like these are a building block that change from the very beginning, while one wouldn't think the brain to change after a single session of learning. 

So, what happens is then getting integrated in the soma, which *integrates information*: if you do the same thing over and over again, there's a learning curve, after which the soma will have integrated the information. Why is the soma doing this integration? We have several parts playing their role in it, the cytosol (composed of a kind of membrane containing a fluid, which contains several organuli, like nucleus, mitochondria, golgi apparatus to deal with waste, the rough&smooth endoplasmatic reticulum) . The *cytoplasm*, labels everything in the cell except the nucleus, while the nucleus contains DNA, which has a specific pattern known as gene expression, having as product the **protein synthesis**.

If the cell is a neuron, then the function is to send/receive information, and this is all written in the DNA. 

It does it through the transformation of DNA into mRNA, carrying information to the sites of protein synthesis in cytoplasm. 

The whole activity of production and processing of information is done in the soma, while it finally goes to the terminal buttons to **pass on the information** to the next neuron. It's really important to see how this actual neuron is hypersimplified into an artificial neuron. 

These terminal buttons terminate in small bubbles, and they also contain numerous mitochondria. So, bried summary: we go from input, to integration, to action potential (whether the signal is sent out, reaching a critical threshold), then output to another neuron.

We've now seen the structure, but we still have to get how neurons communicate, i.e. what is the mechanism through which informations are transmitted. How does this happen? 

The electrochemical brain is such that intra & extracellular fluid is like seawater, and it is made up of atoms/molecules with net electrical charge. For example we have ions (cations/anions) that allow us to generate these signals. Imagine we have a neuron, made of the internal and external, divided by a phospholypidic bilayer membrane, creating a separate internal environment, relatively impermable (relatively independent, except for some channels that allow some chemicals to pass through, *ion channels* and *gated channels*), allowing for systematic communication. Then we have *ion pumps*, that excahgen chemicals for one another, keeping energy to send electrical signals inside the cell. We have an electrochemical system that is able to retain energy, which is then used to send signals. We have two factores influencing the movement of ions (those that allow the system to retain energy), **diffusion** being the natural tendency for ions to disperse (think about these elements inside a liquid, they will go from the high concentration to the low concentration, obtaining a equally distributed solution), and **electrostatic pressure**, which is the force that causes oppositely charged ions to attract each other. These two forces, contributed by some ions (Sodium Na+, Chloride Cl-, Potassium K+, Organic anions A-, with the first two being outside the cell, the other two being inside it), give rise to the membrane potential. The axon membrane separates different concentrations of these ions, diffusion will tend to push out, while electrostatic pressure will tend to push in. These two forces act contrarily. The difference of potential between the inside and outside of the cell is approx. -70mV. The *basic currency* of the electrochemical brain is the *action potential*. If a stimulus is over the threshold, the actoin potential is triggered: the inside becomes positively charged, going from -70mV to somewhat around +30/40. 

Saltatory conduction has some advantages, allowing a faster connection time. The advantage is that every stop takes time, but *the car doesn't have to carry much fuel, so it travels faster*. We need less energy, to maximise the transfer of information. It's more economic, faster, though it obviously has some problems. If it gets into trouble, you could get multiple sclerosis (malignization of these parts), myelin sheath... 

We can distinguish strong stimuli from weak ones thanks to the **firing rate**, i.e. a faster rate is more intense stimula. The rate cannot exceed 1000 per second, meaning that we have a limit to our computational capacity! The refractory period is 1ms. 

The good news is that, so far, we've been focusing on a single neuron, and luckily we have more than one! Imagine how many neurons are receiving and sending informations at any time! This can become noisy or organized. The range of organization can be dramatic, to high levels like playing a piano. 

So, summarizing out, information processing is carried out through elefctrochemical properties of neurons, and the basic building block of information transmission is the **action potential**. 



