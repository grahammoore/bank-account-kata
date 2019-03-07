
# Foreword

I've made some tweaks to the Grade properties to include Lombok to avoid 
the problems seen during the Kata relating to 'equals()' and 'hashCode()'.
So to avoid the distraction the Lombok library is being used to auto-generate
both 'equals()' and 'hashCode()'. This will require a change to the Intellij
settings and enable annotation processing. Intellij may prompt you but if it
does not go to the following "File > Settings > Build, Execution, Deployment > Compiler > Annotation Processors > Enable annotation processing".

Back to the Kata...

# Step 1

Let's think about what user requirements (quoted below)...

### User Requirements
1. I can *Deposit* money into accounts
1. I can *Withdraw* money from accounts
1. I can *Transfer* amounts between accounts (if I have the funds)
1. I can print out an Account balance (date, amount, balance) 
1. I c  an print a statement of account activity (statement) 
1. I can apply Statement filters (just deposits, withdrawal, date)

We also have some additional technical requirements to keep in mind.

To start simple we will only consider the first two user requirements for now and come back to
others later. 

So both *deposit* and *withdraw* are operations on an *account* involving *money*.

There are also some extra considerations, how do we create accounts and how do we create money?
(If you really know how to create lots of money please send me details!!!)

This is how our account class could look like...

````java
class Account {
    static Account newAccount() { ... }
    void deposit(Money amount) { ... }
    void withdraw(Money money) { ... }  
}

class Money {
    static Money amountOf(long amount);
}
````

The 'factory methods' are instead of calling constructors directly to provide the extra considerations.

Check the actual Java file for the real details.

You will see that each method initially just throws an exception. This is so the class
can be compiled without syntax errors but will still fail the tests.
This allows us to craft the tests and have them compile and look sane
in Intellij.



