**07.05.2025**:<br>
This is the first entry which had been overdue for quite some time. This is supposed to be a very flexible MathLibrary
with LaTeX support.<br>

I'll try to summarize everything that I have  accomplished so far. I created the Interface [Expression][expr] with the 
methods:

    public String get();

    public boolean isZero();

    public boolean isPositive();

    public Expression add(Expression v);

    public Expression sub(Expression v);

    public Expression mul(Expression v);

    public Expression div(Expression v);

    public void optimize();

    public void checkIntegrity();

    public void setPrefix(String prefix);

    public void setSuffix(String suffix);

    public String getPrefix();

    public String getSuffix();

squar
In addition, there is the class [**ExpressionModifier**][expr_mod] implementing the [**Expression**][expr] interface. 
This class is then used by other classes such as [**Number**][numb], [**Fraction**][frac], [**SquareRoot**][squar], 
[**Polynom**][poly] and [**Value**][value]. All the classes also use the Expression to make it obvious, that they all 
have those methods  available. Not all the methods have their own implementations if they're not needed. A Number for 
example doesn't have its own integrity while a Fraction isn't allowed to have 0 as a denominator. It is also ensured, 
that whenever a mathematical operation is executed that a new object will be created representing the correct 
mathematical object with correct solution.<br>

I also created two classes for LaTeX support. Firstly [**LatexParser**][latex_parser] and secondly 
[**LatexParseManager**][latex_manager]. The LatexParser can parse the mathematical objects into LaTeX without knowing 
anything about them directly. For example: For parsing a Fraction the LatexParser  expects a String numerator, a String 
denominator, the information if the fraction is supposed to be negative as a  boolean, a String  prefix and a String 
suffix. For parsing Number it expects a String number, a String prefix  and a String suffix. The information needed is 
supplied by LatexParseManager. This class is the bridge among the mathematical objects the LatexParser.

A big selling point is, that you can combine the mathematical objects however you like. A Fraction consists of 
Expressions, so does a Polynom. Yet the LatexParseManager can parse it correctly offering a lot of flexibility.


**10.05.2025**:<br>
I changed the structure of the project. The reasons for that are the following questions I came up with while being
bored in a "Software Engineering 1" lecture. The questions are as followed: 

    How do I make sure, that the different Expression classes don't need to know everything about all the other
    expression classes?

    How do I prevent redundant implementations of certain operations such as addition and multiplication?

    How  does the  library's performance  keep up when used in  bigger project? The problem here is, that all  the
    Expressions are immutable to make sure nothing breaks when the user tries changing an Expression that is being 
    used by multiple instances of other Expressions.

    Is my solution of adding a prefix and a suffix to the Expressions good or does it need futurre improvement?

    How do I make the use of the library more simple for a user? -> Leads to quality of life Constructors.

    How do I want to display decimals?

One thing I came up with is the [**Control**][control] class. Only this class needs to know all the types of Expressions.
This class would end up being too big, so I decided to add another class for every type of Expression that exists. This
approach really does not seem ideal, but it is sufficient for now. All the different Expressions look a lot cleaner now.
The different operations no longer need to be implemented withing an Expression. The ExpressionModifier has the
implementation now which simply calls the Control class by giving itself and the other Expression as arguments.

I also realized how useful the tests are I wrote for the Number implementation. It makes updating the project a lot
easier. The tests itself I also updated. I added the variable errorMessage. Tests that fail now simply put the
corresponding message in there and the caller prints them making it more simple to read and to know who produced the
problem. I renamed some packages, and I'm also looking for a new name for ExpressionModifier since the name does not 
quite fit anymore.

I almost forgot. I also started creating a class diagramm for the project using AstahUML. The reasoning for that was to
make sure I encounter bad project structure as early as possible (thx Mr. Bruhns). I'll add it in a later push.

**10.05.2025**:<br>
Fraction and Number are fully compatible with each other now (technically). I have not written any tests yet. Fraction
has received a new Method called "getReciprocal" as a quality of life. Of course this instantiates a new Fraction. I
also added the method parseString to the LatexParseManager in addition to parseIntoFile. The latter method is kind of
useless. 

**14.05.2025**:<br>
I continued working on the UML-Diagramm of this project. I also worked on the Value class. All four operations are now
fully functional. However, I ran into some problems. How do I display multiplication without calculating it. Is it
something this library should provide or not? Also, a SquareRoot can't have a minus sign in front of it or a direkt 
Value. I will start adding toDos to GitHub now so I don't struggle deciding what I want to be working on. This 
has happened today. The key focus for now should be to make all Expressions compatible with all other Expressions. 
The SquareRoot problem also needs to be addressed soon. I'm still not fully happy with my projects Structure. The 
connections among the different classes are too strong. They need to have too much information. 


[expr]: ../expressions/Expression.java
[expr_mod]: ../expressions/ExpressionModifier.java
[numb]: ../expressions/Number.java
[frac]: ../expressions/Fraction.java
[squar]: ../expressions/SquareRoot.java
[poly]: ../expressions/Polynom.java
[value]: ../expressions/Value.java

[latex_manager]: ../latex/LatexParseManager.java
[latex_parser]: ../latex/LatexParser.java

[control]: ../math/calculators/Control.java