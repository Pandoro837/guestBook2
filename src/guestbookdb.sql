CREATE TABLE guestbook(
    no NUMBER,
    name VARCHAR2(80),
    pw   varchar2(20),
    content varchar2(2000),
    reg_date date,
    PRIMARY KEY(no)
);
DROP TABLE guestbook;

CREATE SEQUENCE seq_no INCREMENT BY 1 START WITH 1; 
DROP SEQUENCE seq_no;

INSERT INTO guestbook VALUES(seq_no.NEXTVAL, '이효리', '23142', '안녕하세요', SYSDATE);

SELECT
    no,
    name,
    pw,
    content,
    TO_CHAR(reg_date, 'yyyy-mm-dd hh:mm:ss') reg_date
FROM
    guestbook;