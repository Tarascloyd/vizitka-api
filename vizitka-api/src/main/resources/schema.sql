-- TRUNCATE TABLE skills, interests, portfolios RESTART IDENTITY CASCADE;

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
    level SMALLINT NOT NULL,
    portfolio_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (portfolio_id) REFERENCES portfolios (id)
);

CREATE TABLE IF NOT EXISTS interests (
    id BIGSERIAL NOT NULL,
    interest_name VARCHAR(255) NOT NULL,
    portfolio_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (portfolio_id) REFERENCES portfolios (id)
);