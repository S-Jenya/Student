package sit.education.student;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import sit.education.student.domain.Classes;
import sit.education.student.domain.Discipline;
import sit.education.student.domain.Institut;
import sit.education.student.domain.Student;
import sit.education.student.service.ClassesService;
import sit.education.student.service.DisciplineService;
import sit.education.student.service.InstitutionService;
import sit.education.student.service.StudentService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

@Configuration
@ComponentScan
public class StudentApplication {

	static Scanner in = new Scanner(System.in);
	static int choice = 0;

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentApplication.class);

		System.out.print("\n----- Регистрация учебного заведения -----\n");
		System.out.println("Ввод наименования: ");
		InstitutionService institutionService = context.getBean(InstitutionService.class);
		Institut institut = institutionService.create(in.nextLine());

		System.out.print("\nРегистрация студента\n");
		System.out.println("Ввод ФИО: ");
		StudentService studentService = context.getBean(StudentService.class);
		Student student = studentService.create(in.nextLine());

		// Зачислим созданного студента в институт
		institutionService.addStudent(institut, student);

		// Назначаем дисциплины
		boolean flag = false;
		do {
			try {
				System.out.print("\nРегистрация занятий для " + student.getFio() + "\n");
				System.out.println("1. Ввести новое занятие");
				System.out.println("2. Вывести список занятий");
				System.out.println("3. Завершить регистрацию дисциплин");
				System.out.print("Ввод: ");
				choice = Integer.parseInt(in.nextLine());

				DisciplineService disciplineService = context.getBean(DisciplineService.class);

				switch (choice) {
					case 1:
						System.out.println("Введите наименование: ");
						String name = in.nextLine();
						System.out.println("Введите часы: ");
						Integer hours = Integer.parseInt(in.nextLine());
						Discipline discipline = disciplineService.create(name, hours);
						studentService.addDiscipline(student, discipline);
						break;

					case 2:
						studentService.getListDiscipline(student);
						break;

					case 3:
						flag = true;
						break;
					default:
						if (flag == false) System.err.println("Некорректные данные. Повторите ввод!\n");
						break;
				}
			} catch (Exception e) {
				System.out.println("Некорректные данные!");
			}

		} while (flag == false);

		// проводим занятия
		flag = false;
		do {
			try {
				System.out.print("\nРегистрация занятий для " + student.getFio() + "\n");
				System.out.println("1. Провести занятие по дисциплине");
				System.out.println("2. Показать электронный дневник по всем дисциплинам");
				System.out.println("3. Завершить работу программы");
				System.out.print("Ввод: ");
				choice = Integer.parseInt(in.nextLine());

				switch (choice) {
					case 1:
						System.out.print("\nПо какой дисциплине желаете провести занятие?\n");
						studentService.getListDiscipline(student);
						int item = Integer.parseInt(in.nextLine());
						// Поиск дисциплины, по которой проводим занятие
						DisciplineService disciplineService = context.getBean(DisciplineService.class);
						Discipline discipline = disciplineService.getByIndex(student, item - 1);

						// Проводим по занятие по дисциплине  Ставим оценку
						System.out.print("\nПоставьте оценку ученику: ");
						int grade = Integer.parseInt(in.nextLine());
						ClassesService classesService = context.getBean(ClassesService.class);
						Classes classes = classesService.create(grade);
						studentService.setStudentClasses(discipline, classes);

						// Выведем Электронный дневник студенте
						studentService.getListDiscipline(student);
						break;

					case 2:
						studentService.getListDiscipline(student);
						break;

					case 3:
						flag = true;
						break;
					default:
						if (flag == false) System.err.println("Некорректные данные. Повторите ввод!\n");
						break;
				}
			} catch (Exception e) {
				System.out.println("Некорректные данные!");
			}

		} while (flag == false);

		System.out.print("\n----- Завершение работы программы -----\n");
	}


}
