select * from users;

select count(id) from users;

select count(distinct id) from users;

select count(*) from book_borrow
where is_returned = 0;

select name from book_categories;


select name from book_categories;

select name, isbn, year, author from books
where name = 'Book Borrow 2';

select * from book_categories;

select b.name, b.isbn,b.year,b.author,bc.name category,b.description from
books b join book_categories bc on b.book_category_id = bc.id where b.name ='Book Borrow 2';





