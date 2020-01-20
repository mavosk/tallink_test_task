const {Builder, By, Key, until} = require("selenium-webdriver");

async function register() {
    let driver = await new Builder().forBrowser("chrome").build();
    await driver.get("http://localhost:8081");
    await driver.findElement(By.name("name")).click();
    await driver.findElement(By.name("name")).sendKeys("Test Meeting");


    await driver.findElement(By.id("location")).click();
    await driver.findElement(By.name("M/S Baltic Queen")).click();

    await driver.findElement(By.name("max_seats")).click();
    await driver.findElement(By.name("max_seats")).sendKeys("4");

    await driver.findElement(By.name("date")).sendKeys("10.10.2020 0003:131");
    await driver.findElement(By.id("register")).click();
    try {

        console.log("Success");
       await driver.quit();
    }

    catch(err){
        handleFailure(err, driver)
    }

}

register();

async function handleFailure(err, driver) {
    console.error('Something went wrong!\n', err.stack, '\n');
   await driver.quit();
}



