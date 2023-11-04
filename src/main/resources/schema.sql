DROP TABLE IF EXISTS BRANDS;
CREATE TABLE BRANDS (
    BRAND_ID VARCHAR(2) NOT NULL,
    BRAND_NAME VARCHAR(50) NOT NULL,
    PRIMARY KEY (BRAND_ID)
);

DROP TABLE IF EXISTS PRICES;
CREATE TABLE PRICES (
    BRAND_ID VARCHAR(2) NOT NULL,
    PRODUCT_ID VARCHAR(10) NOT NULL,
    PRICE_LIST VARCHAR(10) NOT NULL,
    START_DATE TIMESTAMP NOT NULL,
    END_DATE TIMESTAMP NOT NULL,
    PRIORITY INT,
    PRICE DECIMAL(10,2) NOT NULL,
    CURR VARCHAR(3) NOT NULL,
    PRIMARY KEY (BRAND_ID, PRODUCT_ID, PRICE_LIST),
    FOREIGN KEY (BRAND_ID) REFERENCES BRANDS(BRAND_ID)
);