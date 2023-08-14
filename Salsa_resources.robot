*** Settings ***
Library    SeleniumLibrary
Library    Collections
#Library   JiraLibrary
#Library   AppiumLibrary     --Used for Mobile Automation
#Library   RequestLibrary

*** Variables ***
#Jira Variables#--------------------------------------------------------------------------------------
${url_jira}    https://id.atlassian.com/login?continue=https%3A%2F%2Fcaddmicro.atlassian.net&prompt=login
${username_jira}    vitor.santos@caddmicrosystems.com    
${password_jira}    V2ct#l1p001
#End#
#NEW ORDER && RENEWALS VARIABLES------------------------------------------------------------------------
${URL}    https://salsa-dev.vercel.app/login
${login_xpath}    //*[@id="email"]
${login_value}    vitor.santos@caddmicrosystems.com
${login_value_disable}    michael.e.chappel+disabled@gmail.com
${pwd_xpath}    //input[contains(@type,'password')]
${pwd_value}    V2ct#l1p002
${pwd_value_disable}    Iamdisabled123!
${Continue_Btn}    //button[@type='submit'][contains(.,'Continue')]
${Launch_Btn}    //a[@href='/tools/order-fulfillment']    
#${SO_Number_New_value}    SO30000001
${SO_Number_New_xpath}    //input[contains(@id,'SO')]
${Submit_Btn}    //button[@type='submit'][contains(.,'Submit')]
${GP_PO_NUMBER_value}    123434565678
${GP_PO_NUMBER_xpath}    //input[contains(@id,'gpoNumber')]
${Contract_Manager_Name_value}    TST1234
${Contract_Manager_Name_xpath}    //input[@id='autodeskMainContact']
${Contract_Manager_Email_value}    TST1234@gmail.com
${Contract_Manager_Email_xpath}    //input[contains(@id,'autodeskMainContactEmail')]
${Review_Order_Btn}    //button[@type='button'][contains(.,'Review Order')]
${Place_Order_Btn}    //button[@type='button'][contains(.,'Place Order')]
${Close_Btn}    //button[@type='button'][contains(.,'Close')]    
${Create_New_Order_Btn_PopUp}    //button[@type='button'][contains(.,'Create New Order')]
${Renewals_Btn}    //button[contains(.,'Renewal')]
${Contract_Number_xpath}    //span[contains(@class,'chevron absolute top-1/2 right-4 -translate-y-1/2 w-0 h-0 border-[6px] border-b-0 border-transparent border-t-gray-400 transition-all ')]    
${Contract_Number_ValueClickXpath}    //button[contains(@aria-hidden,'true')]
${New_Btn}    //button[contains(.,'New')]
#CADD CARE VARIABLES-----------------------------------------------------------------------------
${CADD_CARE_BTN}    //p[@class='text-primary font-sans font-bold uppercase text-xs'][contains(.,'CADD Care')]
${Create_Ticket_xpath}    //button[@type='button'][contains(.,'Create Ticket')]
#${Email_xpath}    //input[contains(@id,'email')]
#${Email_value}    test123@gmail.com
${Subject_xpath}    //input[contains(@id,'subject')]
${Subject_value}    AUTOMATION TEST :: test1235 %$¨%&* test1235 %$¨%&* test1235 %$¨%&* test1235 %$¨%&* test1235 %$¨%&* test1235 %$¨%&* test1235 %$¨%&* test1235 %$¨%&* test1235 %$¨%&* 
${Description_xpath}    //textarea[contains(@id,'description')]
${Description_value}    AUTOMATION TEST :: test1235 %$¨%&* test1235 %$¨%&* test1235 %$¨%&* test1235 %$¨%&* test1235 %$¨%&* test1235 %$¨%&* test1235 %$¨%&* test1235 %$¨%&* test1235 %$¨%&*test1235 %$¨%&* test1235 %$¨%&* test1235 %$¨%&* test1235 %$¨%&* test1235 %$¨%&* test1235 %$¨%&* test1235 %$¨%&* test1235 %$¨%&* test1235 %$¨%&*
${Software_xpath}    //span[contains(@class,'chevron absolute top-1/2 right-4 -translate-y-1/2 w-0 h-0 border-[6px] border-b-0 border-transparent border-t-gray-400 transition-all ')]
${Software_value}    (//button[@type='button'][contains(.,'CADD Community')])[2]
${Submit_create_ticket_btn}    //button[@type='submit'][contains(.,'Create Ticket')]
${Search_Tickets_xpath}    //input[contains(@placeholder,'Search your tickets...')]
${Search_Tickets_value}    409
${In_Progress_Tickets_xpath}    //button[contains(.,'In-Progress')]    
${Complete_Tickets_xpath}    //button[contains(.,'Complete')]
${Cancel_Btn}    //button[contains(.,'Cancel')]
#COURSES VARIABLES----------------------------------------------------------------------------
${COURSES_BTN_MENU}    //p[contains(.,'Courses')]
${Search_field_xpath}    //input[@placeholder='Search our course catalog...']
${Search_field_value}    30

#API VARIABLES-------------------------------------------------------------------------------------
# ${URL_BASE}    https://petstore.swagger.io/
# ${id}

*** Keywords ***
Abrir o Navegador
    Open Browser    browser=chrome
    Maximize Browser Window

#Close Browser
Fechar Navegador 
    Capture Page Screenshot
    Close Browser

#APIs
# Iniciar Sessão
#     Create Session    salsa-test    ${URL_BASE}    verify=true

#Jira Setup Conection
#Configurar conexão Jira
#    [Arguments]    ${url_jira}    ${username_jira}    ${password_jira}
#    Configure Jira Connection  ${url_jira}  ${username_jira}  ${password_jira}


#Test Case 1- Access Salsa : Success ------------------------------------------------------------------------------------------
#step 1
Given user input website https://salsa-dev.vercel.app/login
    Go To    url=${URL}
    Capture Page Screenshot
        
#step 2
When user input login field
    Input Text    locator=${login_xpath}    text=${login_value}
    Capture Page Screenshot
    Sleep    2s

#step 3
and user input password
    Input Password    locator=${pwd_xpath}    password=${pwd_value}
    Capture Page Screenshot

#step 4
and user can access Salsa
    Click Element    locator=${Continue_Btn}
    Capture Page Screenshot
    Sleep    2s

#Test Case 2- Access Salsa : Create New Order ------------------------------------------------------------------------------------------
#step 1
and user click on Launch button
    Wait Until Element Is Visible    locator=${Launch_Btn}
    Click Element    locator=${Launch_Btn}
    Capture Page Screenshot
    Sleep    2s

#step 2
and input the SO Number "${SO_NUMBER}" 
    Input Text    locator=${SO_Number_New_xpath}    text=${SO_NUMBER}
    Capture Page Screenshot
    Sleep    2s

#step 3
and click on 'Submit' button
    Click Element    locator=${Submit_Btn}
    Capture Page Screenshot
    Sleep    5s

#step 4
and fill 'GP PO Number'
    Input Text    locator=${GP_PO_NUMBER_xpath}    text=${GP_PO_NUMBER_value}
    Capture Page Screenshot

#step 5
and fill 'Contract Manager Name'
    Input Text    locator=${Contract_Manager_Name_xpath}    text=${Contract_Manager_Name_value}
    Capture Page Screenshot

#step 6
and fill 'Contract Manager Email'
    Input Text    locator=${Contract_Manager_Email_xpath}    text=${Contract_Manager_Email_value}
    Capture Page Screenshot

#step 7
and click on 'Review Order' button
    Get Selenium Implicit Wait
    Click Element    locator=${Review_Order_Btn}
    Capture Page Screenshot
    Sleep    2s

#step 8
and click on 'Place Order' button
    Get Selenium Implicit Wait
    Click Element    locator=${Place_Order_Btn}
    Capture Page Screenshot
    Sleep    2s

#step 9
and user create successfully a SO
    Get Selenium Implicit Wait
    Capture Page Screenshot
    Sleep    2s

#step 10
and Validate button close
    Get Selenium Implicit Wait
    Click Element    locator=${Close_Btn}
    Capture Page Screenshot
    Sleep    2s

#step 11
Then click on 'Create New Order' button
    Get Selenium Implicit Wait
    Click Element    locator=${Create_New_Order_Btn_PopUp}
    Capture Page Screenshot
    Sleep    2s

#Test Case 3- Access Salsa : Create Renewals ------------------------------------------------------------------------------------------
#step 1
and user click tab Renewals
    Get Selenium Implicit Wait
    Click Button    locator=${Renewals_Btn}
    Capture Page Screenshot
    Sleep    3s

#step 2
and user click tab New
    Get Selenium Implicit Wait
    Click Button    locator=${New_Btn}
    Capture Page Screenshot
    Sleep    1s

#step 3
and click Contract Number field
    Get Selenium Implicit Wait
    Wait Until Element Is Visible    locator=${Contract_Number_xpath}
    Click Element    locator=${Contract_Number_xpath}
    Capture Page Screenshot
    Sleep    3s

#step 4
and click Contract Number value
    Get Selenium Implicit Wait
    Click Element    locator=${Contract_Number_ValueClickXpath}
    Capture Page Screenshot
    Sleep    3s


#Test Case 4- Access Salsa: User disabled------------------------------------------------------------------------------------------
#step 1
When user input login field disabled
    Input Text    locator=${login_xpath}    text=${login_value_disable}
    Capture Page Screenshot
    Sleep    1s

#step 2
and user input password disabled
    Input Password    locator=${pwd_xpath}    password=${pwd_value_disable}
    Capture Page Screenshot
    Sleep    1s

#step 3
and user cannot access Salsa
    Click Element    locator=${Continue_Btn}
    Capture Page Screenshot
    Sleep    2s

#Test Case 7 - CADD Care: Create Ticket: CADD Community
#step 1
and user click CADD CARE menu
    Wait Until Element Is Visible    locator=${CADD_CARE_BTN}
    Click Element    locator=${CADD_CARE_BTN}
    Capture Page Screenshot
    Sleep    2s

# #step 2
and click on create ticket button
    Wait Until Element Is Visible    locator=${Create_Ticket_xpath}
    Click Element    locator=${Create_Ticket_xpath}
    Capture Page Screenshot
    Sleep    2s

# #step --
# and fill 'e-mail' field
#     Wait Until Element Is Visible    locator=${Email_xpath}
#     Input Text    locator=${Email_xpath}    text=${Email_value}
#     Capture Page Screenshot
#     Sleep    2s    

#step 3
and fill 'subject' field
    Input Text    locator=${Subject_xpath}    text=${Subject_value}
    Capture Page Screenshot    
    Sleep    2s

#step 4
and fill 'description' field
    Input Text    locator=${Description_xpath}    text=${Description_value}
    Capture Page Screenshot    
    Sleep    2s

#step 5
and click 'software' Equal CADD Community
    Wait Until Element Is Visible    locator=${Software_xpath}
    Click Element    locator=${Software_xpath}
    Capture Page Screenshot
    Sleep    2s
    Click Element    locator=${Software_value}
    Capture Page Screenshot
    Sleep    2s

#step 6
Then click on 'Create Ticket' button
    Click Element    locator=${Submit_create_ticket_btn} 
    Capture Page Screenshot
    Sleep    2s

#Test Case 8- CADD CARE : Search Tickets - All Tickets
Then input ticket to be searched
    Input Text    locator=${Search_Tickets_xpath}    text=${Search_Tickets_value}
    Capture Page Screenshot    
    Sleep    2s  

#Test Case 9- CADD CARE : Search Tickets - In Progress  
and click In Progress Tickets
    Wait Until Element Is Visible    locator=${In_Progress_Tickets_xpath}
    Click Element    locator=${In_Progress_Tickets_xpath} 
    Capture Page Screenshot
    Sleep    2s

#Test Case 10- CADD CARE : Search Tickets - Complete
and click Complete Tickets
    Click Element    locator=${Complete_Tickets_xpath} 
    Capture Page Screenshot
    Sleep    2s

#Test Case 11- CADD CARE : New Ticket - Cancel / BUG SAL-392
and click 'cancel' button
    Click Element    locator=${Cancel_Btn} 
    Capture Page Screenshot
    Sleep    2s

#Test Case 12 - Courses
and user click COURSES menu
    Wait Until Element Is Visible    locator=${COURSES_BTN_MENU}
    Click Element    locator=${COURSES_BTN_MENU} 
    Capture Page Screenshot
    Sleep    2s

#Test Case 13- COURSES - Search our course catalog
Then user input the course to search
    Input Text    locator=${Search_field_xpath}    text=${Search_field_value}
    Capture Page Screenshot
    Sleep    2s