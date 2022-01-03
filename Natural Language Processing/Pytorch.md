# Guide to PyTorch

The main way to store a dataset in PyTorch is as a [`torch.utils.data.Dataset`](https://pytorch.org/docs/stable/data.html#module-torch.utils.data) object, which basically is a list of items and labels.

Famous datasets can be downloaded through `torchvision.datasets` utility class.

```python
  import torch
  import torchvision

  train_ds = torchvision.datasets.CIFAR10(root="/data/", train=True, transform=transforms.ToTensor(), download=True)
  test_ds = torchvision.datasets.CIFAR10(root="/data/", train=False, transform=transforms.ToTensor(), download=True)
```
