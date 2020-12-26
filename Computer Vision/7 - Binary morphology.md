# Binary morphology

Binary morphology is more than *cleaning the binarization*. These are simple and effective tools to improve and analyse binary images, in particular those achieved by foreground/background segmentation. You can apply similar operators to grayscale images too. 

Formally, it is a **set of operators** that may correct, improve and perform analysis on binarized images. The language of mathematical morphology is the language of **set operators**, i.e. operators defined on sets, which process *one set by another set*. Obviously, one set will be the image and the other one a kernel. All these sets are indeed subsets of the **cartesian product of the set of integers per itself**: <img src="svgs/ec98e5a999a97406ff498c3555463115.svg?invert_in_darkmode" align=middle width=19.63472444999999pt height=26.76175259999998pt/>, obtained by the cartesian product <img src="svgs/7f3305ad3d1b5aa2ab8becb1fac50d77.svg?invert_in_darkmode" align=middle width=46.255563749999986pt height=22.465723500000017pt/> with <img src="svgs/84df98c65d88c6adf15d4645ffa25e47.svg?invert_in_darkmode" align=middle width=13.08219659999999pt height=22.465723500000017pt/> being the set of integers. 

Given the set <img src="svgs/84df98c65d88c6adf15d4645ffa25e47.svg?invert_in_darkmode" align=middle width=13.08219659999999pt height=22.465723500000017pt/> of integers:![Set of integers E](./res/set-of-integers-E.png)

we take the Cartesian product, obtaining:

![E^2](./res/set-e-squared.png)

Now, <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.32879834999999pt height=22.465723500000017pt/> will be the set of foreground pixels, and <img src="svgs/dc23de63181109d8d84f1d63cf459d20.svg?invert_in_darkmode" align=middle width=22.563292949999987pt height=27.6567522pt/> the set of background pixels. The binary morphology operators manipulate either <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.32879834999999pt height=22.465723500000017pt/> or <img src="svgs/dc23de63181109d8d84f1d63cf459d20.svg?invert_in_darkmode" align=middle width=22.563292949999987pt height=27.6567522pt/> through a second set <img src="svgs/c40edcf41a94a96ba273be26255926b7.svg?invert_in_darkmode" align=middle width=54.84575909999999pt height=26.76175259999998pt/>, structuring the elements, which will process <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.32879834999999pt height=22.465723500000017pt/> or its complement <img src="svgs/dc23de63181109d8d84f1d63cf459d20.svg?invert_in_darkmode" align=middle width=22.563292949999987pt height=27.6567522pt/>. Being a subset of <img src="svgs/ec98e5a999a97406ff498c3555463115.svg?invert_in_darkmode" align=middle width=19.63472444999999pt height=26.76175259999998pt/>, <img src="svgs/61e84f854bc6258d4108d08d4c4a0852.svg?invert_in_darkmode" align=middle width=13.29340979999999pt height=22.465723500000017pt/> is a set of points in <img src="svgs/ec98e5a999a97406ff498c3555463115.svg?invert_in_darkmode" align=middle width=19.63472444999999pt height=26.76175259999998pt/>.

## Dilation (Minkowski sum)

The **dilation** is defined as follows:
<p align="center"><img src="svgs/5e391e064c817abe62f7c8730c843a6a.svg?invert_in_darkmode" align=middle width=358.51117665pt height=19.9563243pt/></p>
![Dilation](./res/dilation.png)

## Erosion

The **erosion** is defined as follows:
<p align="center"><img src="svgs/24628bc48e0c917f7667632a5872e552.svg?invert_in_darkmode" align=middle width=271.726587pt height=19.9563243pt/></p>
It can be expressed in terms of translations of the structuring element:
<p align="center"><img src="svgs/3fe875817b866b5ce24e11985c8e7ddd.svg?invert_in_darkmode" align=middle width=201.58083824999997pt height=19.9563243pt/></p>
It involves subtraction of the elements of one set from those of the other:
<p align="center"><img src="svgs/951e6b36f8e3cfc746522be09200978c.svg?invert_in_darkmode" align=middle width=342.98589269999997pt height=19.9563243pt/></p>
It is not commutative, associative only if the structuring element can be decomposed in terms of dilations, anti-extensive (i.e. the eroded set is contained into the original one) if the structuring element includes the origin, and it is an increasing transformation: <img src="svgs/1f43579d64ad99246942aa97a54df4fc.svg?invert_in_darkmode" align=middle width=186.68192894999999pt height=22.465723500000017pt/>.

Contours may be used to extract contours, followed by a subtraction. 

Dilation and erosion have a great duality. In fact, given <img src="svgs/ed2486c471b96d6eb56da65b99f56197.svg?invert_in_darkmode" align=middle width=13.29340979999999pt height=31.141535699999984pt/>, <img src="svgs/4a1a65613f079d7aec9ae9be37f5724b.svg?invert_in_darkmode" align=middle width=168.96049004999998pt height=31.50689519999998pt/>, it can be shown that 
<p align="center"><img src="svgs/e2152a5ad816c36a1698df06dc02c34d.svg?invert_in_darkmode" align=middle width=139.52299349999998pt height=41.168988299999995pt/></p>
and if <img src="svgs/61e84f854bc6258d4108d08d4c4a0852.svg?invert_in_darkmode" align=middle width=13.29340979999999pt height=22.465723500000017pt/> is symmetric (<img src="svgs/413131eb5631ef9a853dfc5179eab97d.svg?invert_in_darkmode" align=middle width=48.50442299999998pt height=31.141535699999984pt/>), we can say that:
<p align="center"><img src="svgs/cc55af182a393bf3c9d13bd9088aea2f.svg?invert_in_darkmode" align=middle width=139.52299349999998pt height=36.164383199999996pt/></p>
Erosion and dilation by the same structuring element can be chained to selectively remove from either the foregrund or background, parts that do not match the structuring element *without causing any distortion to the other parts.*

## Opening and closing

Opening might be considered as a small erosion, while closing might be considered as a small dilation.

So, **opening** is just an erosion followed by a dilation on the same structuring element. So, we can now reason about trying to give an intuitive interpretation of the morphology operator. If we look at the original set and the open set, we can note that we've obtained B, translated at a certain position: **it's kind of just a translation of <img src="svgs/61e84f854bc6258d4108d08d4c4a0852.svg?invert_in_darkmode" align=middle width=13.29340979999999pt height=22.465723500000017pt/> at a certain position**. It's a union of translations of the structuring element: **we cancel all of the pieces which do not match perfectly the structuring element**!

**Closing** is just a dilation followed by an erosion. 

We can now derive the already known interpretations for dilation (union of the translations of the strcturing element) and erosion (union of the positions at which we can translate the structuring element, added to the original one). 

We firstly have to discuss an important property: unlike erosion and dilation, opening and closing are **idempotent**. If we apply them again, we get the same result. 

We can derive the interpretation in terms of translations, dealing with dilation and erosion and knowing how we can interpret them in terms of translations of the structuring element. Let's now consider the latter operation for opening, i.e. the dilation. How can we write it in terms of translation of the structuring element? We know that it is the union of the translations of the structuring element, but where? It's the union of the tranlsation of \B at each point beloning to <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.32879834999999pt height=22.465723500000017pt/> erosion <img src="svgs/61e84f854bc6258d4108d08d4c4a0852.svg?invert_in_darkmode" align=middle width=13.29340979999999pt height=22.465723500000017pt/>. But now, if point <img src="svgs/deceeaf6940a8c7a5a02373728002b0f.svg?invert_in_darkmode" align=middle width=8.649225749999989pt height=14.15524440000002pt/> does belong to <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.32879834999999pt height=22.465723500000017pt/> erosion <img src="svgs/61e84f854bc6258d4108d08d4c4a0852.svg?invert_in_darkmode" align=middle width=13.29340979999999pt height=22.465723500000017pt/>, what can we say about <img src="svgs/3969d1484b6cf71c9ab9ae835be844c1.svg?invert_in_darkmode" align=middle width=19.54825784999999pt height=22.465723500000017pt/>, the translation <img src="svgs/61e84f854bc6258d4108d08d4c4a0852.svg?invert_in_darkmode" align=middle width=13.29340979999999pt height=22.465723500000017pt/> of the structuring element at point <img src="svgs/deceeaf6940a8c7a5a02373728002b0f.svg?invert_in_darkmode" align=middle width=8.649225749999989pt height=14.15524440000002pt/>? A point belongs to an erosion if we can translate the structuring element and have it fully contained in the initial set. A point <img src="svgs/deceeaf6940a8c7a5a02373728002b0f.svg?invert_in_darkmode" align=middle width=8.649225749999989pt height=14.15524440000002pt/> does belong to <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.32879834999999pt height=22.465723500000017pt/> erosion <img src="svgs/61e84f854bc6258d4108d08d4c4a0852.svg?invert_in_darkmode" align=middle width=13.29340979999999pt height=22.465723500000017pt/> if when we translate it, it belongs to <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.32879834999999pt height=22.465723500000017pt/>. So this <img src="svgs/3969d1484b6cf71c9ab9ae835be844c1.svg?invert_in_darkmode" align=middle width=19.54825784999999pt height=22.465723500000017pt/> enjoys the property of having to be contained into <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.32879834999999pt height=22.465723500000017pt/>. 

We can say that opening is given by the union of all those translations of the structuring element, such that those translations are fully contained inside <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.32879834999999pt height=22.465723500000017pt/>. 
<p align="center"><img src="svgs/f823c81328129f752d830c5b3e382641.svg?invert_in_darkmode" align=middle width=328.64004029999995pt height=39.1417719pt/></p>
The duality between erosion and dilation might intuitively infer a duality between opening and clsoing. Duality means that dilation of the background may be thought of as erosion of the foreground, and viceversa.

