CREATE DATABASE programacion;

USE programacion;

CREATE TABLE departamentos (
	dept_no INTEGER NOT NULL,
	dnombre VARCHAR(255) NOT NULL,
	loc VARCHAR(255) NOT NULL,
	PRIMARY KEY (dept_no)
);

CREATE TABLE empleados (
	emp_no INTEGER NOT NULL,
	apellido VARCHAR(255) NOT NULL,
	oficio VARCHAR(255) NOT NULL,
	dir INTEGER,
	fecha_alt DATE NOT NULL,
	salario DECIMAL(20,2),
	comision DECIMAL(20,2),
	dept_no INTEGER NOT NULL,
	PRIMARY KEY (emp_no),
	CONSTRAINT FK_dept_no
		FOREIGN KEY (dept_no) REFERENCES departamentos(dept_no)
);

INSERT INTO departamentos VALUES (10, "CONTABILIDAD", "SEVILLA");
INSERT INTO departamentos VALUES (20, "INVESTIGACIÓN", "MADRID");
INSERT INTO departamentos VALUES (30, "VENTAS", "BARCELONA");
INSERT INTO departamentos VALUES (40, "PRODUCCIÓN", "BILBAO");

INSERT INTO empleados VALUES (7369, "SÁNCHEZ", "EMPLEADO", 7902, "1990-12-17", 1040.00, NULL, 20);
INSERT INTO empleados VALUES (7499, "ARROYO", "VENDEDOR", 7698, "1990-02-20", 1500.00, 390.00, 30);
INSERT INTO empleados VALUES (7521, "SALA", "VENDEDOR", 7698, "1991-02-22", 1625.00, 650.00, 30);
INSERT INTO empleados VALUES (7566, "JIMÉNEZ", "DIRECTOR", 7839, "1991-04-02", 2900.00, NULL, 20);
INSERT INTO empleados VALUES (7654, "MARTÍN", "VENDEDOR", 7698, "1991-09-29", 1600.00, 1020.00, 30);
INSERT INTO empleados VALUES (7698, "NEGRO", "DIRECTOR", 7839, "1991-05-01", 3005.00, NULL, 30);
INSERT INTO empleados VALUES (7782, "CEREZO", "DIRECTOR", 7839, "1991-06-09", 2885.00, NULL, 10);
INSERT INTO empleados VALUES (7788, "GIL", "ANALISTA", 7566, "1991-11-09", 3000.00, NULL, 20);
INSERT INTO empleados VALUES (7839, "REY", "PRESIDENTE", NULL, "1991-11-17", 4100.00, NULL, 10);
INSERT INTO empleados VALUES (7844, "TOVAR", "VENDEDOR", 7698, "1991-09-08", 1350.00, 0.00, 30);
INSERT INTO empleados VALUES (7876, "ALONSO", "EMPLEADO", 7788, "1991-09-23", 1430.00, NULL, 20);
INSERT INTO empleados VALUES (7900, "JIMENO", "EMPLEADO", 7698, "1991-12-03", 1335.00, NULL, 30);
INSERT INTO empleados VALUES (7902, "FERNÁNDEZ", "ANALISTA", 7566, "1991-12-03", 3000.00, NULL, 20);
INSERT INTO empleados VALUES (7934, "MUÑOZ", "EMPLEADO", 7782, "1992-01-23", 1690.00, NULL, 10);