TRUNCATE TABLE skills, portfolios RESTART IDENTITY CASCADE;

CREATE TABLE IF NOT EXISTS portfolios (
    id BIGSERIAL NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    home_city VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS skills (
    id BIGSERIAL NOT NULL,
    skill_name VARCHAR(255) NOT NULL,
    level VARCHAR(255) NOT NULL,
    portfolio_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES portfolios (id)
);