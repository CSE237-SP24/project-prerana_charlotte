#!/bin/bash

cd src/bankapp
if [ -f BankAccount.java ]; then
	#javac command to compile
	javac BankAccount.java
	#java to run the code
	java BankAccount.java
else
	echo "BankAccount.java not found"
fi

