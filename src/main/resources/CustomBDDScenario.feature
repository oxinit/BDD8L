Feature: FeatureTask
  Scenario Outline:appropriate query form search field
    Given User opens '<homePage>' page
    When User fills search field with '<Search text>'
    And User clicks find button
    Then User checks query generated '<Search text>'
    Examples:
      | homePage               |Search text|
      | https://www.amazon.com |12-354984sd12426SADff****|
      | https://www.amazon.com |Added to Cart|
      | https://www.amazon.com |Blah blah bla|
      | https://www.amazon.com/Amazon-Basics-Shaggy-Sherpa-Blanket/dp/B08FTMMZTN/ref=pd_mrai_hpb_ps_hpb_3/135-5741802-4032366?pd_rd_w=QWsOF&pf_rd_p=b54e0907-a629-4ef9-8ae9-4bf98ae93e45&pf_rd_r=X6GR3CJ88HJ9G4627DRT&pd_rd_r=eaa8979b-8170-43fd-bdeb-08d15c7f7102&pd_rd_wg=BWjSJ&pd_rd_i=B08FTMMZTN&psc=1|Hellp|
  Scenario Outline:Product test
    Given User opens '<ProductPage>' page
    When User checks visibility of product image
    And User checks visibility of product price
    And User checks in Stock Inscription
    Then User clicks add to cart button
    And User checks does product price match to price in cart

    Examples:
      |ProductPage|
      |https://www.amazon.com/dp/B07B64T9B3?psc=1&pf_rd_p=b9c4a2ec-084b-4239-9a34-c9686515e635&pf_rd_r=852ARAF10SA8PMYS05EC&pd_rd_wg=Ni1Xa&pd_rd_i=B07B64T9B3&pd_rd_w=aci6I&pd_rd_r=4436fed4-f32d-45ec-b519-48c6ad6ec1d6&ref_=pd_luc_rh_tsdvd_crc_04_04_t_img_lh |
      |https://www.amazon.com/dp/B07TV8M755/ref=sspa_dk_detail_0?psc=1&pd_rd_i=B07TV8M755&pd_rd_w=jNBGc&pf_rd_p=91afecf5-8b2e-41e2-9f11-dc6992c6eaa1&pd_rd_wg=rNbXu&pf_rd_r=3BMRBPMKMVNJ0DJC6WAR&pd_rd_r=26714370-a15e-4665-93ae-87c8c9f45e2b&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUFaM09ZOUw1NE5SMU8mZW5jcnlwdGVkSWQ9QTA4NzYwNTAxRU1aMzg2SUxGSzlKJmVuY3J5cHRlZEFkSWQ9QTAwMDUzNDMzNUlUTlBMU1NHMFZFJndpZGdldE5hbWU9c3BfZGV0YWlsJmFjdGlvbj1jbGlja1JlZGlyZWN0JmRvTm90TG9nQ2xpY2s9dHJ1ZQ==|
      |https://www.amazon.com/Amazon-Basics-Shaggy-Sherpa-Blanket/dp/B08FTMMZTN/ref=pd_mrai_hpb_ps_hpb_3/135-5741802-4032366?pd_rd_w=QWsOF&pf_rd_p=b54e0907-a629-4ef9-8ae9-4bf98ae93e45&pf_rd_r=X6GR3CJ88HJ9G4627DRT&pd_rd_r=eaa8979b-8170-43fd-bdeb-08d15c7f7102&pd_rd_wg=BWjSJ&pd_rd_i=B08FTMMZTN&psc=1                                                                                                                                                                       |
