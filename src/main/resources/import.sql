INSERT INTO roles(name) VALUES('ADMIN');
INSERT INTO roles(name) VALUES('USER');
INSERT INTO users (registration_date, email, password, role_id) VALUES ('2023-01-01', 'john@email.com', '{noop}john', 1);
INSERT INTO users (registration_date, email, password, role_id) VALUES ('2023-05-05', 'jane@email.com', '{noop}jane', 2);


INSERT INTO decks (name, user_id) VALUES ('HTML', 1);
INSERT INTO decks (name, user_id) VALUES ('CSS', 1);
INSERT INTO decks (name, user_id) VALUES ('JavaScript', 1);

INSERT INTO flashcards (front, back, deck_id) VALUES ('What does a doctype do?', '<p>Instructions to the browser about what version of HTML the webpage is written in, ensuring the web page is parsed the same way across web browsers.</p>', 1);
INSERT INTO flashcards (front, back, deck_id) VALUES ('How do you serve a page with content in multiple languages?', '<p>By setting the lang attributes on the various elements within the page.</p>', 1);
INSERT INTO flashcards (front, back, deck_id) VALUES ('What kinds of things must you be wary of when designing or developing for multilingual sites?', '<p>There are quite a few different nuances to pay attention to including:</p><ul><li>Including the lang attribute</li><li>Allowing users to change the language</li><li>Minimize text in raster based images</li><li>Text overflow when translated</li><li>How colors are perceived</li><li>Date and currency formats</li><li>Language reading direction</li><li>Don\'t concatenate translated strings</li></ul>', 1);

INSERT INTO flashcards (front, back, deck_id) VALUES ('What does a doctype do?', '<p>Instructions to the browser about what version of HTML the webpage is written in, ensuring the web page is parsed the same way across web browsers.</p>', 2);
INSERT INTO flashcards (front, back, deck_id) VALUES ('What does a doctype do?', '<p>Instructions to the browser about what version of HTML the webpage is written in, ensuring the web page is parsed the same way across web browsers.</p>', 2);
INSERT INTO flashcards (front, back, deck_id) VALUES ('What does a doctype do?', '<p>Instructions to the browser about what version of HTML the webpage is written in, ensuring the web page is parsed the same way across web browsers.</p>', 2);

INSERT INTO flashcards (front, back, deck_id) VALUES ('What does a doctype do?', '<p>Instructions to the browser about what version of HTML the webpage is written in, ensuring the web page is parsed the same way across web browsers.</p>', 3);
INSERT INTO flashcards (front, back, deck_id) VALUES ('What does a doctype do?', '<p>Instructions to the browser about what version of HTML the webpage is written in, ensuring the web page is parsed the same way across web browsers.</p>', 3);
INSERT INTO flashcards (front, back, deck_id) VALUES ('What does a doctype do?', '<p>Instructions to the browser about what version of HTML the webpage is written in, ensuring the web page is parsed the same way across web browsers.</p>', 3);