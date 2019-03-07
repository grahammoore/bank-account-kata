
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

This is how our account and money classes could look like...

````java
class Account {
    static Account newAccount() { ... }
    void deposit(Money amount) { ... }
    void withdraw(Money money) { ... }  
}

class Money {
    static Money amountOf(long amount) { ... }
}
````

Check the actual Java file for the real details. The 'factory methods' are instead of calling constructors directly to provide the extra considerations.

You will see that each method initially just throws an exception. This is so the class
can be compiled without syntax errors but will still fail the tests.
This allows us to craft the tests and have them compile and look sane
in Intellij.

Now checkout Step 2.

# Step 2

Now we are going to write some tests.

#####*Money....*

- Create some money.
- Compare some money with the same amounts.
- Compare some money with different amounts.

#####*Account*

- Create a new account with an opening balance.
- Get an accounts current balance.
- Deposit some money in an account.
- Withdraw some money in an account.

Some of the above tests can be tested on their own in isolation.
However some operations can only be tested together, for instance 
the 'newAccount()' method of on account with an opening balance is best tested with
the get balance operation.

The same is true for the money class, the 'amountOf()' money method on it's own
cannot be tested but by comparing two money objects it is possible 
to verify the 'amountOf()' method.

Look at 'MoneyTest' to see some tests for 'amountOf()'.

Now we know we can create Money objects and compare them let's look at
a test for creating a new account and checking it's balance.

````java
public class AccountTest {
    @Test
    public void createANewAccount() {
        Account account = Account.newAccount();
        assertThat(account.balance()).isEqualTo(Money.amountOf(0));
    }
}
````

Ah but we don't have a 'balance()' method in our original account class so the class
will not compile and Intellij complains. 
To get Intellij to create one for us select the balance method (put the cursor in the
method name) and press Alt-Enter. Select the "Create method 'balance' in 'Account'".
For the method body throw.

Or check out Step 3.
