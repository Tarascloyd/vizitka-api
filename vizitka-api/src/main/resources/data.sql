INSERT INTO portfolios (first_name, last_name, home_city) VALUES 
    ('Taras', 'Shvetsov', 'Novosibirsk'),
    ('Mark', 'Berger', 'London'),
    ('Ted', 'Parker', 'Deli')
;

INSERT INTO skills (skill_name, level, portfolio_id) VALUES 
    ('sql', 3, 1),
    ('java', 4, 1),
    ('spring', 3, 1)
;

INSERT INTO interests (interest_name, portfolio_id) VALUES 
    ('Иностранные языки', 1),
    ('Программирование', 1),
    ('Путешествия', 1)
;