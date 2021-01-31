
CREATE TABLE userAuth(
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    PRIMARY KEY (username),
    id_user INT NOT NULL REFERENCES userData(id_user)

)

CREATE TABLE userData(
    id_user INT IDENTITY(1,1) NOT NULL,
    name VARCHAR(80),
    age INT,
    subscription_type VARCHAR(80),
    PRIMARY KEY (id_user)
)
