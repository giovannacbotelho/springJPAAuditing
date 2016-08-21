create table USER (
	ID identity primary key,
	NAME varchar not null,
	VERSION BIGINT,
	CREATED_DATE TIMESTAMP,
	LAST_MODIFIED_DATE TIMESTAMP,
	CREATED_BY_ID BIGINT,
	LAST_MODIFIED_BY_ID BIGINT,
	constraint USER_CREATED_BY_USER foreign key (CREATED_BY_ID) references USER (ID),
	constraint USER_LAST_MODIFIED_BY_USER foreign key (LAST_MODIFIED_BY_ID) references USER (ID)
);

create table CUSTOMER (
	ID identity primary key,
	FIRST_NAME varchar not null,
	LAST_NAME varchar not null,
	CREATED_DATE TIMESTAMP,
	LAST_MODIFIED_DATE TIMESTAMP,
	CREATED_BY_ID BIGINT,
	LAST_MODIFIED_BY_ID BIGINT,
	constraint CUS_CREATED_BY_USER foreign key (CREATED_BY_ID) references USER (ID),
	constraint CUS_LAST_MODIFIED_BY_USER foreign key (LAST_MODIFIED_BY_ID) references USER (ID)
);

