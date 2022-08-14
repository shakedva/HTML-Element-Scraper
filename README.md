# HTML Element Scraper

A Java program for parsing and scraping HTML elements from a given URL.

## Implmentation

The program can support a variety of different HTML element types by utilizing the Decorator design pattern.
Each HTML element type inherits from the base `Decorator` class.


## Execution

The command line syntax and expected parameters: `java Main < options > < url > < output file name >`

The options can be:
* a - print the list of links, attribute href.
* i - print the list of images, attribute src.
* h - print the list of h1 headers.

All user input is checked and validated in the custom validator `ArgumentsValidator`.