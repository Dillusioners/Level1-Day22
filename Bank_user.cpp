// for input and output
# include <iostream>
// for std::numeric_limits
# include <limits>
// for dynamic arrays
# include <vector>
/*
	Author: LeeTuah
	Program: 
	Date: 00/00/23
	For SuperB League event
*/

// decleration of fix_cin
void fix_cin();

// class User to store all the Users in the bank
class User{
	private:
		// name -> stores the name of User
		// password -> stores the password of the User's account
		// balance -> stores the balance in account
		std::string name, password;
		int balance;
		
	public:
		// constructor of the User class
		// n -> name 
		// p -> password
		// b -> balance
		User(std::string n, std::string p, int b);
		// sets the value of a User variable equal to another User variable
		User operator= (User);
		
		// returns the name of User
		std::string getName();
		// returns the password of User
		std::string getPassword();
		// returns the balance of User
		int getBalance();
		
		// sets the name of User
		// n -> name
		void setName(std::string n);
		// sets the password of the User
		// p -> password
		void setPassword(std::string p);
		// sets the balance of the User
		// b -> balance
		void setBalance(int b);
};

// Following are the inititalizations of User class functions:

User::User(std::string n, std::string p, int b){
	// setting all details
	name = n;
	password = p;
	balance = b;	
}

User User::operator=(User c2){
	// copying all the data from other User to here
	name = c2.getName();
	password = c2.getPassword();
	balance = c2.getBalance();
	return *this;
}

std::string User::getName(){
	return name; // returns name
}

std::string User::getPassword(){
	return password; // returns password
}

int User::getBalance(){
	return balance; // returns balance
}

void User::setName(std::string n){
	name = n; // sets name	
}

void User::setPassword(std::string p){
	password = p; // sets password
}

void User::setBalance(int b){
	balance = b; // sets balance
}

// User class functions end here

// class Bank for the structure of the bank
class Bank{
	private:
		// Users -> all the accounts created by Users 
		// logged -> stores whether User is logged in or not
		// logged_User -> stores the data of the currently logged in User
	
		std::vector<User> Users;
		bool logged;
		User *logged_User;
		
	public:
		// Constructor of the bank
		Bank();
		
		// main method from where the bank's features are accessed'
		bool main();
		// registers a User in the bank
		void register_();
		// logs in a User in the bank
		void login();
		// deposits money in the User's account'
		void deposit();
		// withdraws money from User's account'
		void withdraw();
};

// Initialization of all Bank functions below

Bank::Bank(){
	// Inilializing variables
	logged = false;
	logged_User = new User("", "", 0);
}

bool Bank::main(){
	int choice; // stores User choice
	
	// welcome message screen
	std::cout << "\nWelcome to Dillusioners Bank!\n\n";
	// this line is only printed if User is logged in
	if(logged)
	std::cout <<"Welcome " << logged_User->getName() 
	                <<". Your current bank balance is $" << logged_User->getBalance() << '\n';
	// prints the menu itself
	std::cout << "The following are your options:\n";
	std::cout << "1. Register\n";
	std::cout << "2. Login\n";
	std::cout << "3. Deposit\n";
	std::cout << "4. Withdraw\n";
	std::cout << "5. Exit\n";
	std::cout << ">> ";
	std::cin >> choice;
	fix_cin();
	
	// switch case for User choice
	switch(choice){
		// Exit
		case 5: {
			// exits from program
			std::cout << "Thanks for checking out the back!";
			return false;	
		}
		
		// Register
		case 1: {
			// registers the User
			register_();
			break;
		}
		
		// Login
		case 2: {
			// logs in the User
			login();
			break;
		}
		
		// Deposit
		case 3: {
			// kick out if not logged in
			if(logged) deposit();
			else std::cout << "Login / Register to access funds!\n";
			break;	
		}
		
		// Withdraw
		case 4: {
			// kicks out if not logged in
			if(logged) withdraw();
			else std::cout << "Login / Register to access funds!\n";
			break;
		}
		
		// Not matching with any choice
		default: {
			std::cout << "Invalid input provided!\n";	
		}
	}
	
	// Returns true as the User has not exited from program
	return true;
}

void Bank::register_(){
	// variable declaration
	std::string n, p;
	int b;
	
	// asks User for name, pass and balance
	std::cout << "Enter your name: ";
	std::cin >> n;
	std::cout << "Enter your password: ";
	std::cin >> p;
	std::cout << "Enter your balance: ";
	std::cin >> b;
	fix_cin();
	
	// logs in the User to the bank
	logged = true;
	// creates a User User
	User *c = new User(n, p, b);
	// logs User in Users vector
	Users.push_back(*c);
	// updates the currently logged User
	logged_User = c;
	std::cout << "Successfully registered!\n";
}

void Bank::login(){
	// variable declaration
	std::string n, p;
	
	// asks User for name and password
	std::cout << "Enter your name: ";
	std::cin >> n;
	std::cout << "Enter your password: ";
	std::cin >> p;
	
	// loops through all the Users
	for(auto i = Users.begin(); i != Users.end(); i++){
		// if the name and pass matched with the current iteration
		if(n == i->getName() && p == i->getPassword()){
			// log into the bank
			std::cout << "Successfully logged in!\n";
			*logged_User = *i;
			logged = true;
			return;
		}	
	}
	// runs when no matching User or password was provided
	std::cout << "Couldnot log in!\n";
}

void Bank::deposit(){
	int d;
	
	// asks for cash to deposits
	std::cout << "How much you want to deposit?: ";
	std::cin >> d;
	fix_cin();
	
	// if cash is negative, it is made positive
	if(d < 0) d *= -1;
	
	// updates the balance of the User
	logged_User->setBalance(logged_User->getBalance() + d);	
}

void Bank::withdraw(){
	int d;
	
	// asks for cash amount to withdraw
	std::cout << "How much you want to withdraw?: ";
	std::cin >> d;
	fix_cin();
	
	// if cash if negative, make it posititve
	if(d < 0) d *= -1;
	
	// updates the balance amount
	logged_User->setBalance(logged_User->getBalance() - d);
}

// fixes std::cin if bad input is provided
void fix_cin(){
	if(std::cin.fail()){
		// clears std::cin and removes all the bad input from it
		std::cin.clear();
		std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');	
	}	
}

// execution starts from here
// int argc -> total argument count from run
// char** argv -> all the provided arguments in a string array
int main(int argc, char** argv){
	// variable declaration
	Bank bank;
	bool run = true;
	
	// running the program
	while(run){
		run = bank.main();	
	}
	return 0;
}
