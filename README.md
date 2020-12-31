# CPS 510-Final

<h1 align="center" style="border-bottom:none">Database I: Cloths DB  </h1>

<p align="center">
    <img src="https://i.imgur.com/bfZ5wSY.jpg" alt="imageofproject" width="800" />

</p>

<details open>
<summary>Table of Contents</summary>

1. [About The Project](#about-the-project)
    - [Built With](#built-with)
    - [Langauge Choices](#language-choices)
1. [Getting Started](#getting-started)
1. [Usage](#usage)
1. [Contact](#contact)

</details>

# About The Project

This was the final project for Databases Systems I, it is a Java GUI program that allows for users to interact with a simulated clothing store SQL database  

The runnable program was intended to allow for managers to:

- View and update the status and information of employees
- View and update current stock of items
- View and update recent purchases
- View and update transactions
- View and update customers who are subscribed to any newsletters
- Search for anything in the data

## Built With

- Java (JDBC and GUI)
- MySQL
- Oracle SQL Developer

## Language Choices

- This was a 4-month long project that had us select an industry where we could model a database after, our team decided to go with a clothing store
- We first had to map out a relational diagram by hand and that diagram later became more advanced as we joined several tables together and added in more entities as we progressed
- Our initial tests and production were done using Oracle SQL Developer as we were given an Oracle Database from Ryerson
- Then when it was time to create a running program we decided to use Java as we were most familiar and comfortable using it

# Getting Started

To get a local copy up and running follow these simple steps

1. Make sure you have an Oracale Database that you can connect to
1. Clone the repo

    ```text
    git clone https://github.com/Calvin-Yap/ClothsDatabse.git
    ```

1. Enter your login keys in `src/dblogin.java`

# Usage

## Standard

To load in the data and get started:

1. Start by locating the buttons on the right pannel
1. Here you will need to first press the "Connect to DB button"
1. Next press the "Load Data" and "Load Tables" to fill the tables

- It optional to "Drop Tables" or "Create Tables" this was implemented for a requirement to drop all tables and to create them anew

## Adding an Entry

To add an entry:

1. Select the table that you wish to add an entry to
1. Fill out the text box above with the details that you want to be added
    - Make sure the information is correct, if it is missing any required keys it will show an error in the actions menu
1. Press the "Add Entry" button

## Search

To use the search function:

1. In the text box next to "Search Query" fill out what you would like to search for
1. Press the button and the results will be shown bellow

# Contact

Please contact me through email with any questions or inquires

Calvin Yap - calvin.gh.yap@gmail.com

Project Link -https://github.com/Calvin-Yap/ClothsDatabse
