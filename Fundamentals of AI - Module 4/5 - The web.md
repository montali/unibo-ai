# The web

[Recording](https://web.microsoftstream.com/video/37c32bcf-dcb7-4d72-9137-a11542d1ceaa)

XML files are a great tool, with built-in grammar definitions and no presentation information. It is not human readable, especially in high cardinality. It's a costly and expensive standard, but it's nice. We'll use it to represent knowledge, according to standard W3C, encoding the possible smallest bit of information: triples in which we have subject, predicate and object. 

In PROLOG we'd call these predicate with arity 2. 

We can represent knowledge as a graph, incurring in a complication of the problem: one node will be linked to lots of nodes... We could also have empty nodes, bags/sets, many variations... In the end, we always have this notion of **triples**.

RDF as a standard supports classes (as in OOP), collections and meta-sentences (e.g. *Marco says Federico is the author of webpage XY*, being a triple Federico -author-> XY.html and an outer triple Marco -says-> {} ).

RDF is a little more expensive standard for entity-relationships DBs. RDFa is an extension of this that makes it more user-friendly, and has no need to repeat significant data in the document. 

We'd also like a language for querying these databases: **SPARQL**. 

## Knowledge graphs

The T-box was a bottleneck. Google needed a business push: up to 2010 Google's business model was based on ads on the search page. So, in 2011 they started modifying their approach from a search engine to a **query answering engine**. This keeps users in Google pages. So, how did Google solve these problems? They pushed towards the creation of a common, simple vocabulary (**no TBox!**: they didn't want high computational costs in solving queries), then create a simple yet robust corpus of types, properties, etc... Finally, they pushed the webs to adopt these standards: everyone will follow what Google wants. Google's knowledge graph is enormous. The solution was **throwing away logics!** Logical formulas are now missing, being substituted by knowledge graphs. The price to pay is that they now must store a huge quantity of informations.

