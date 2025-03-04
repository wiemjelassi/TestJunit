package com.example.PracticeAutomationTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FromFieldsPage extends PageObject {

	public FromFieldsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	    // Localisation des éléments avec @FindBy
	    @FindBy(xpath = "//h1[@itemprop='headline']")
	    private WebElement formFieldsLink;

	    @FindBy(xpath = "//div[@id='top-wrap']/section/div/h1")
	    private WebElement pageTitle;

	    @FindBy(xpath = "//article[@id='post-1103']/div/p")
	    private WebElement instructionText;

	    @FindBy(xpath = "//form[@id='feedbackForm']/label")
	    private WebElement nameInput;

	    @FindBy(xpath = "//label[normalize-space()='Password']")
	    private WebElement passwordInput;
	    
	    

	    @FindBy(id = "drink1")
	    private WebElement favoriteDrink;

	    @FindBy(id = "color1")
	    private WebElement favoriteColor;

	    @FindBy(id = "automation")
	    private WebElement automationDropdown;

	    @FindBy(id = "email")
	    private WebElement emailInput;

	    @FindBy(id = "submit-btn")
	    private WebElement submitButton;

		public WebElement getFormFieldsLink() {
			return formFieldsLink;
		}

		public void setFormFieldsLink(WebElement formFieldsLink) {
			this.formFieldsLink = formFieldsLink;
		}

		public WebElement getPageTitle() {
			return pageTitle;
		}

		public void setPageTitle(WebElement pageTitle) {
			this.pageTitle = pageTitle;
		}

		public WebElement getInstructionText() {
			return instructionText;
		}

		public void setInstructionText(WebElement instructionText) {
			this.instructionText = instructionText;
		}

		public WebElement getNameInput() {
			return nameInput;
		}

		public void setNameInput(WebElement nameInput) {
			this.nameInput = nameInput;
		}

		public WebElement getPasswordInput() {
			return passwordInput;
		}

		public void setPasswordInput(WebElement passwordInput) {
			this.passwordInput = passwordInput;
		}

		public WebElement getFavoriteDrink() {
			return favoriteDrink;
		}

		public void setFavoriteDrink(WebElement favoriteDrink) {
			this.favoriteDrink = favoriteDrink;
		}

		public WebElement getFavoriteColor() {
			return favoriteColor;
		}

		public void setFavoriteColor(WebElement favoriteColor) {
			this.favoriteColor = favoriteColor;
		}

		public WebElement getAutomationDropdown() {
			return automationDropdown;
		}

		public void setAutomationDropdown(WebElement automationDropdown) {
			this.automationDropdown = automationDropdown;
		}

		public WebElement getEmailInput() {
			return emailInput;
		}

		public void setEmailInput(WebElement emailInput) {
			this.emailInput = emailInput;
		}

		public WebElement getSubmitButton() {
			return submitButton;
		}

		public void setSubmitButton(WebElement submitButton) {
			this.submitButton = submitButton;
		}

	
}
