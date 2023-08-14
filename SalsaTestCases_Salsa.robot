*** Settings ***
Resource    Salsa_resources.robot
Test Setup    Abrir o Navegador
Test Teardown    Fechar Navegador



*** Test Cases ***
Test Case 1- Access Salsa: Success
    Given user input website https://salsa-dev.vercel.app/login
    When user input login field
    and user input password
    and user can access Salsa

Test Case 2- Access Salsa : Create New Order
    Given user input website https://salsa-dev.vercel.app/login
    When user input login field
    and user input password
    and user can access Salsa
    and user click on Launch button
    and input the SO Number "SO30033172"
    and click on 'Submit' button
    and fill 'GP PO Number'
    and fill 'Contract Manager Name'
    and fill 'Contract Manager Email'
    and click on 'Review Order' button
    and click on 'Place Order' button
    and user create successfully a SO
    and Validate button close
    and click on 'Place Order' button
    Then click on 'Create New Order' button

Test Case 3- Access Salsa : Create Renewals
    Given user input website https://salsa-dev.vercel.app/login
    When user input login field
    and user input password
    and user can access Salsa
    and user click on Launch button
    and user click tab Renewals
    and input the SO Number "SO30000001"
    # and user click tab New
    # and user click tab Renewals
    and click Contract Number field
    and click Contract Number value
    and click on 'Submit' button
    and fill 'GP PO Number'
    and click on 'Review Order' button
    and click on 'Place Order' button
    and user create successfully a SO
    and Validate button close

Test Case 4- Access Salsa: User disabled
    Given user input website https://salsa-dev.vercel.app/login
    When user input login field disabled
    and user input password disabled
    and user cannot access Salsa

Test Case 5- Access Salsa : Create Renewals Quantity Mismatch
    Given user input website https://salsa-dev.vercel.app/login
    When user input login field
    and user input password
    and user can access Salsa
    and user click on Launch button
    and user click tab Renewals
    and input the SO Number "SO30000002"
    #and user click tab New
    #and user click tab Renewals
    and click Contract Number field
    and click Contract Number value
    and click on 'Submit' button
    and fill 'GP PO Number'
    and click on 'Review Order' button
    and click on 'Place Order' button
    and user create successfully a SO
    and Validate button close


Test Case 6- Access Salsa : Create Renewals Wrong Terms on Item
    Given user input website https://salsa-dev.vercel.app/login
    When user input login field
    and user input password
    and user can access Salsa
    and user click on Launch button
    and user click tab Renewals
    and input the SO Number "SO30000003"
    # and user click tab New
    # and user click tab Renewals
    and click Contract Number field
    and click Contract Number value
    and click on 'Submit' button
    and fill 'GP PO Number'
    and click on 'Review Order' button
    and click on 'Place Order' button
    and user create successfully a SO
    and Validate button close

Test Case 7- CADD CARE : Create Tickets - CADD Community
    Given user input website https://salsa-dev.vercel.app/login
    When user input login field
    and user input password
    and user can access Salsa
    and user click CADD CARE menu
    and click on create ticket button
    #and fill 'e-mail' field
    and fill 'subject' field
    and fill 'description' field
    and click 'software' Equal CADD Community
    Then click on 'Create Ticket' button

Test Case 8- CADD CARE : Search Tickets - All Tickets
    Given user input website https://salsa-dev.vercel.app/login
    When user input login field
    and user input password
    and user can access Salsa
    and user click CADD CARE menu
    Then input ticket to be searched

Test Case 9- CADD CARE : Search Tickets - In Progress
    Given user input website https://salsa-dev.vercel.app/login
    When user input login field
    and user input password
    and user can access Salsa
    and user click CADD CARE menu
    and click In Progress Tickets
    Then input ticket to be searched

Test Case 10- CADD CARE : Search Tickets - Complete
    Given user input website https://salsa-dev.vercel.app/login
    When user input login field
    and user input password
    and user can access Salsa
    and user click CADD CARE menu
    and click Complete Tickets
    Then input ticket to be searched

Test Case 11- CADD CARE : New Ticket - Cancel
    Given user input website https://salsa-dev.vercel.app/login
    When user input login field
    and user input password
    and user can access Salsa
    and user click CADD CARE menu
    and click on create ticket button
    and fill 'subject' field
    and fill 'description' field
    and click 'cancel' button
    and click on create ticket button

Test Case 12- COURSES
    Given user input website https://salsa-dev.vercel.app/login
    When user input login field
    and user input password
    and user can access Salsa
    and user click COURSES menu

Test Case 13- COURSES - Search our course catalog
    Given user input website https://salsa-dev.vercel.app/login
    When user input login field
    and user input password
    and user can access Salsa
    and user click COURSES menu
    Then user input the course to search

    
# APITEST - API ONLINE
#     [Tags]
#     Iniciar Sessão

#Create new Issue on Jira
#   ${issue} =    Create Issue    Test Project    Bug    Summary of the issue
#    Should Be Equal As Strings    ${issue.status}    Open