# LL1 Parsing Algorithm
# Variant 2

Parsing Algorithm on paper:

![](https://github.com/encodedemotions/lpfcok/blob/main/Lab4/ss/screen1.jpg)

As we can see there are cells with multiple transitions in them, which means that this grammar is not LL1-parseable.

The grammar with which I have tested the Algorithm is the following:

S > E

E > FcA

A > b | dD

D > Fe

F > aX

X > baX | eps

This is a LL1-parseable grammar. It has been written in the following form in the grammar.txt file:

![](https://github.com/encodedemotions/lpfcok/blob/main/Lab4/ss/screen2.png)

Example of output with the input string "abacdae":

![](https://github.com/encodedemotions/lpfcok/blob/main/Lab4/ss/screen3.png)

Example of output with the input string "cabacaa":

![](https://github.com/encodedemotions/lpfcok/blob/main/Lab4/ss/screen4.png)