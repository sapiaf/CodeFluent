INSERT INTO roles(name) VALUES('ADMIN');
INSERT INTO roles(name) VALUES('USER');
INSERT INTO users (registration_date, email, password, role_id) VALUES ('2023-01-01', 'john@email.com', '{noop}john', 1);
INSERT INTO users (registration_date, email, password, role_id) VALUES ('2023-05-05', 'jane@email.com', '{noop}jane', 2);

INSERT INTO tags (name) VALUES ('HTML');
INSERT INTO tags (name) VALUES ('CSS');
INSERT INTO tags (name) VALUES ('JavaScript');
INSERT INTO tags (name) VALUES ('Java');
INSERT INTO tags (name) VALUES ('Spring Framework');


INSERT INTO decks (name, user_id, description) VALUES ('HTML', 1, 'A deck focused on Hypertext Markup Language (HTML), the standard language used to create web pages. It covers the structure and elements used in web development.');
INSERT INTO decks (name, user_id, description) VALUES ('CSS', 1, 'This deck concentrates on Cascading Style Sheets (CSS), a language used for describing the presentation of a document written in HTML. It includes styling elements, layouts, and design techniques.');
INSERT INTO decks (name, user_id, description) VALUES ('JavaScript', 1, 'This deck revolves around JavaScript, a programming language commonly used to create interactive effects within web browsers. It covers scripting, event handling, and DOM manipulation.');
INSERT INTO decks (name, user_id, description) VALUES ('CS Theory', 1, 'This deck encompasses Computer Science Theory, covering fundamental concepts, algorithms, data structures, and theoretical aspects of computer science.');
INSERT INTO decks (name, user_id, description) VALUES ('Java', 1, 'Focused on the Java programming language, this deck covers object-oriented programming, syntax, libraries, and application development using Java.');
INSERT INTO decks (name, user_id, description) VALUES ('Spring Framework', 1, 'A deck concentrating on the Spring Framework, an open-source application framework for Java used to build robust and scalable enterprise applications. It covers dependency injection, MVC architecture, and various modules within Spring.');

INSERT INTO flashcards (front, back, deck_id, due_date, creation_date) VALUES ('What does a doctype do?', '<p>Instructions to the browser about what version of HTML the webpage is written in, ensuring the web page is parsed the same way across web browsers.</p>', 1, NOW(), NOW());
INSERT INTO flashcards (front, back, deck_id, due_date, creation_date) VALUES ('How do you serve a page with content in multiple languages?', '<p>By setting the lang attributes on the various elements within the page.</p>', 1, NOW(), NOW());
INSERT INTO flashcards (front, back, deck_id, due_date, creation_date) VALUES ('What kinds of things must you be wary of when designing or developing for multilingual sites?', '<p>There are quite a few different nuances to pay attention to including:</p><ul><li>Including the lang attribute</li><li>Allowing users to change the language</li><li>Minimize text in raster based images</li><li>Text overflow when translated</li><li>How colors are perceived</li><li>Date and currency formats</li><li>Language reading direction</li><li>Don\'t concatenate translated strings</li></ul>', 1, NOW(), NOW());

INSERT INTO flashcards (front, back, deck_id, due_date, creation_date) VALUES ('What does a doctype do?', '<p>Instructions to the browser about what version of HTML the webpage is written in, ensuring the web page is parsed the same way across web browsers.</p>', 2, NOW(), NOW());
INSERT INTO flashcards (front, back, deck_id, due_date, creation_date) VALUES ('What does a doctype do?', '<p>Instructions to the browser about what version of HTML the webpage is written in, ensuring the web page is parsed the same way across web browsers.</p>', 2, NOW(), NOW());
INSERT INTO flashcards (front, back, deck_id, due_date, creation_date) VALUES ('What does a doctype do?', '<p>Instructions to the browser about what version of HTML the webpage is written in, ensuring the web page is parsed the same way across web browsers.</p>', 2, NOW(), NOW());

INSERT INTO flashcards (front, back, deck_id, due_date, creation_date) VALUES ('What does a doctype do?', '<p>Instructions to the browser about what version of HTML the webpage is written in, ensuring the web page is parsed the same way across web browsers.</p>', 3, NOW(), NOW());
INSERT INTO flashcards (front, back, deck_id, due_date, creation_date) VALUES ('What does a doctype do?', '<p>Instructions to the browser about what version of HTML the webpage is written in, ensuring the web page is parsed the same way across web browsers.</p>', 3, NOW(), NOW());
INSERT INTO flashcards (front, back, deck_id, due_date, creation_date) VALUES ('What does a doctype do?', '<p>Instructions to the browser about what version of HTML the webpage is written in, ensuring the web page is parsed the same way across web browsers.</p>', 3, NOW(), NOW());