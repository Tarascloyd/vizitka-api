INSERT INTO portfolios (first_name, last_name, title, home_city) VALUES 
    ('Taras', 'Shvetsov', 'Full Stack Developer', 'Novosibirsk'),
    ('Mark', 'Berger', 'Java Developer', 'London'),
    ('Ted', 'Parker', 'Full Stack Developer', 'Deli')
;

INSERT INTO skills (skill_name, level, portfolio_id) VALUES 
    ('sql', 3, 1),
    ('java', 4, 1),
    ('english', 5, 1),
    ('javascript', 3, 1),
    ('spring', 2, 1)
;

INSERT INTO interests (interest_name, portfolio_id) VALUES 
    ('Languages', 1),
    ('Coding', 1),
    ('Fishing', 1),
    ('Traveling', 1)
;