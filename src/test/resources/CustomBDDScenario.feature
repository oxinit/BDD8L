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
    And User change delivery country
    When User checks visibility of product image
    And User checks in Stock Inscription
    And User checks visibility of product price
    Then User clicks add to cart button
    And User checks does product price match to price in cart

    Examples:
      |ProductPage|
      |https://www.amazon.com/dp/B07B64T9B3?psc=1&pf_rd_p=b9c4a2ec-084b-4239-9a34-c9686515e635&pf_rd_r=852ARAF10SA8PMYS05EC&pd_rd_wg=Ni1Xa&pd_rd_i=B07B64T9B3&pd_rd_w=aci6I&pd_rd_r=4436fed4-f32d-45ec-b519-48c6ad6ec1d6&ref_=pd_luc_rh_tsdvd_crc_04_04_t_img_lh |
      |https://www.amazon.com/dp/B08HB6PVCQ?ref_=Oct_DLandingS_D_404914b0_NA                                                                                                                                                                   |
      |https://www.amazon.com/dp/B09PKLMJDF/ref=sbl_dpx_bedding-blankets-throws_B00ET9N1OU_0                                                                                                                                                                     |