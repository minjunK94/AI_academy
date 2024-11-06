-- [9] 쇼핑몰 DB 설계 및 생성, 입력, 수정
DROP TABLE MEMBER;
DROP TABLE PRODUCT;
DROP TABLE ORDERS;
DROP TABLE ORDER_LIST;
DROP TABLE CART;

CREATE TABLE MEMBER(
    mID VARCHAR2(10) PRIMARY KEY,
    mNAME VARCHAR2(12) NOT NULL,
    mTEL VARCHAR2(30) NOT NULL,
    mADDRESS VARCHAR2(255),
    mEAIL VARCHAR2(255) NOT NULL
);


CREATE TABLE PRODUCT(
    pCODE VARCHAR2(255) PRIMARY KEY,
    PRICE NUMBER(10) CHECK(PRICE>0),
    pNAME VARCHAR2(50),
    pSTOCK NUMBER(38) CHECK(pSTOCK >=0)
);

CREATE TABLE ORDERS(
    oNO VARCHAR2(255) PRIMARY KEY,
    oNAME VARCHAR2(12) NOT NULL,
    oADDR VARCHAR2(255) NOT NULL,
    oTEL VARCHAR2(255) NOT NULL,
    oDATE DATE DEFAULT SYSDATE,
    mID VARCHAR2(10) NOT NULL,
    FOREIGN KEY(mID) REFERENCES MEMBER(mID)
);

CREATE TABLE ORDER_LIST (
    odNO NUMBER(5) PRIMARY KEY,
    oNO VARCHAR2(255) NOT NULL,
    pCODE VARCHAR2(255) NOT NULL,
    oQTV NUMBER(3) NOT NULL,
    COST NUMBER(9),
    FOREIGN KEY(oNO) REFERENCES ORDERS(oNO),
    FOREIGN KEY(pCODE) REFERENCES PRODUCT(pCODE)
);

CREATE TABLE CART(
    cNO NUMBER(2) PRIMARY KEY,
    mID VARCHAR2(20) NOT NULL,
    pCODE VARCHAR2(5) NOT NULL,
    QTV NUMBER(3) NOT NULL,
    COST NUMBER(9),
    FOREIGN KEY(mID) REFERENCES MEMBER(mID),
    FOREIGN KEY(pCODE) REFERENCES PRODUCT(pCODE)
);

CREATE SEQUENCE CART_SEQ
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE ORDER_LIST_SEQ
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;
    
CREATE SEQUENCE ORDERS_SEQ
    MAXVALUE 99999
    NOCACHE
    NOCYCLE;
    
INSERT INTO MEMBER
    VALUES ('abc', '홍길동', '010-9999-9999', '서울시 관악구', 'hong@hong.com'); 
INSERT INTO MEMBER
    VALUES ('def', '김김동', '010-8888-8888', '경기도 수원시', 'kim@kim.com');

SELECT * FROM MEMBER;
SELECT * FROM PRODUCT;
INSERT INTO PRODUCT
    VALUES ('A1', '3000', '맥주', '100');
INSERT INTO PRODUCT
    VALUES ('A2', '200', '마스크', '100');
INSERT INTO PRODUCT
    VALUES ('B1', '3000', '땅콩', '100');
INSERT INTO PRODUCT
    VALUES ('B2', '5000', '오징어', '100');
INSERT INTO PRODUCT
    VALUES ('C1', '7000', '소독약', '100');
    
SELECT TO_CHAR(SYSDATE, 'RRMMDD')||TRIM(TO_CHAR(1, '000')) oNO FROM DUAL;
INSERT INTO CART VALUES
  (CART_SEQ.NEXTVAL, 'abc', 'A1', 3, (SELECT PRICE FROM PRODUCT WHERE PCODE='A1')*3);
SELECT * FROM CART;