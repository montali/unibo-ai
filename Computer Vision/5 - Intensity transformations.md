# Intensity transformations

We want to improve an image so that it becomes easier to analyze for CV.

We'll not go over too many image processing techniques. Intensity transformation are image processing operators aimed at enhancing the quality (the contrast) of the image. At most such operators rely on the computation of the gray-level histogram of the input image, we start by defining this useful function. The gray-level histogram of ani mage is simply a function associating to each gray-level the number of pixels in the image taking that level. 

Computing the histogram is straightforward: we define avector $H$ having as many elements as the number of grayscale levels, then scan the image to increment the element of the vector corresponding to the level of the pixel.

