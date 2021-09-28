# 4. N-gram language models

## Language models

### Probabilistic language models

These models are based on assigning probabilities to sentences, in order to achieve spell and grammatical error correction, smart typing, machine translation, argumentative and alternative communication systems, speech recognition, summarization, question-answering and also other tasks.

If _w<sub>i</sub><sup>n</sup>_ is a sequence of _n_ words _w<sub>1</sub>, ..., w<sub>n</sub>_, the **chain rule** says that:

![image](https://user-images.githubusercontent.com/31796254/135098719-12d404c1-9a97-4ec1-9845-d3cfa50d04fd.png)

To estimate these probabilities the naive approach of just count nd divide is not suitable, since there are so many possible sentences that we will never see enough data for estimating them. 


