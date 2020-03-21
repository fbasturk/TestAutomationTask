Feature: Bein Sports Connect Thailand Subscription Test Case

  Scenario: Start To Browser And Test in Base
    Given At BeinSports Start Browser "Chrome" And Test

  Scenario: Navigate to website in Base
    Given At BeinSports GoTo "https://connect-th.beinsports.com/en"

  Scenario: Subscription start in HomePage
    Given At BeinSports Click "Subscription"

  Scenario: Register to One Month(Monthly Pass with One Week Free Trial) package in SubscribePage
    Given At BeinSports Click "ONE MONTH"
    Given At BeinSports Click "Monthly Pass with One Week Free Trial Button"

  Scenario: Creating an Account in CreateAccountPage
    When At BeinSports SetText "First Name" Type "Tester Name"
    When At BeinSports SetText "Last Name" Type "Tester Surname"
    When At BeinSports SetText "Email Or Mobile Number" Type "Random Mail"
    When At BeinSports SetText "Create A Password" Type "123456test"
    Given At BeinSports Click "Privacy Policy"
    Given At BeinSports Click "Create Account"

  Scenario: Make Payment with Credit Card in PaymentMethodPage
    Given At BeinSports Click "Close Account Verification Info"
    Then At BeinSports Check "Validate package price"
    Given At BeinSports Click "Agreed to the Terms And Conditions"
    Given At BeinSports Click "Pay Now"

  Scenario: Entering credit card information and making payment in CardInfoPage
    When At BeinSports SetText "Cardholder's name" Type "Tester Name"
    When At BeinSports SetText "Card number" Type "4444333322221111"
    When At BeinSports Select "10" "Month"
    When At BeinSports Select "2022" "Year"
    When At BeinSports SetText "Card verification code" Type "312"
    Given At BeinSports Click "Yes, I CONFIRM MY PAYMENT"
    Then At BeinSports Check "Making Payment"

    Scenario: Finish Browser And Test in Base
      Then At BeinSports Finish Browser And Test
