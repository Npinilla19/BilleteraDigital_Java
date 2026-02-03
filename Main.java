package alke_wallet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Usuario usuario = null;
		BilleteraDigital billetera = null;
		int opcion; // para ingresar las opciones del menu
		
		// creo menu principal de opciones 
		do {
			System.out.println("\n===== MENÚ =====");
			System.out.println("1. Registrar usuario");
			System.out.println("2. Ingresar a cuenta");
			System.out.println("3. Eliminar Usuario");
			System.out.println("4. Salir");
			System.out.println("Ingrese una opcion : ");
			
			opcion = scanner.nextInt();
			scanner.nextLine();
			
			switch (opcion) {
			
			// creamos el usuario o confirmamos que ya haya usuario creado, en este caso una billetera solo pertenece a 1 usuario, no se pueden ingresar multiples
			
			case 1: 
				if(usuario != null) {
					System.out.println("Ya existe usuario creado.");
					pausar(scanner); 
		
					break;
				}
				
				 System.out.print("Nombre: ");
				    String nombre = scanner.nextLine();

				    System.out.print("Rut: ");
				    String rut = scanner.nextLine();

				    System.out.print("Correo: ");
				    String correo = scanner.nextLine();

				    System.out.print("Contraseña: ");
				    String contraseña = scanner.nextLine();

				    usuario = new Usuario(nombre, rut, correo, contraseña);
				    billetera = new BilleteraDigital(usuario);

				    System.out.println("Usuario registrado correctamente.");
				    pausar(scanner);
				    break;
				
	
				
			case 2: 
				
				// ingreso de usuario, validamos si hay usuarios creados, de tener usuarios creados te da acceso a la billetera 
				
				if (usuario == null) {
			        System.out.println("Primero debe registrar un usuario.");
			        pausar(scanner);
			        break;
			    }

			    System.out.print("Ingrese Rut: ");
			    String rutIngresado = scanner.nextLine();

			    System.out.print("Ingrese contraseña: ");
			    String contraseñaIngresada = scanner.nextLine();

			    if (usuario.validarLogin(rutIngresado, contraseñaIngresada)) {
			        System.out.println("Acceso correcto a la billetera.");
			    } else {
			        System.out.println("Rut o contraseña incorrectos.");
			    }
			    pausar(scanner);
			 
			    // cuando ingresamos a la billetera le da el submenu para ingresar a los datos de la billetera y sus cuentas
			    int opcionSubmenu;

			    do {
			        System.out.println("\n===== BIENVENIDO A TU BILLETERA =====");
			        System.out.println("1. Crear Cuenta");
			        System.out.println("2. Mostrar Cuentas");
			        System.out.println("5. Volver al menú principal");
			        System.out.print("Opción: ");

			        opcionSubmenu = scanner.nextInt();
			        scanner.nextLine();
			        
			        switch (opcionSubmenu) {
			        
			        case 1:
			        	// caso 1 da la opcion de crear cuentas nuevas en este caso un usuario puede tener multiples cuentas 
			        if (billetera == null) {
				        System.out.println("Primero debe registrar un usuario.");
				        pausar(scanner);
				        break;
				    }

				    System.out.print("Nombre de la cuenta (ej: principal/ negocio/ coelgio): ");
				    String nombreCuenta = scanner.nextLine();

				    System.out.print("Banco: ");
				    String banco = scanner.nextLine();

				    System.out.print("Tipo de cuenta (vista / corriente / ahorro) : ");
				    String tipoCuenta = scanner.nextLine();
				    
				    System.out.print("Ingrese número de cuenta : ");
				    String numeroCuenta = scanner.nextLine();

				    billetera.agregarCuenta(nombreCuenta, banco, tipoCuenta, numeroCuenta);

				    System.out.println("Cuenta bancaria registrada correctamente.");
				    pausar(scanner);
				    break;
				    
				case 2:
					// caso 2 te muestra las cuentas creadas, en este caso se ingresa un nuevo submenu para ingresar a cada cuenta 
					 if (billetera == null) {
					        System.out.println("No hay cuentas creadas.");
					        pausar(scanner);
					        break;
					    }

					    billetera.mostrarCuentas();

					    System.out.print("Seleccione una cuenta: ");
					    int indice = scanner.nextInt();
					    scanner.nextLine();

					    Cuenta cuenta = billetera.obtenerCuenta(indice - 1);

					    if (cuenta == null) {
					        System.out.println("Cuenta inválida.");
					        pausar(scanner);
					        break;
					    }
					    
					    int opcionSubmenuCuenta;
					    
					    // En este nuevo submenu vemos lo que podemos gestionar por cada cuenta individual

					    do {
					        System.out.println("\n--- CUENTA: " + cuenta.getNombreCuenta() + " ---");
					        System.out.println("1. Depositar");
					        System.out.println("2. Girar (Retirar)");
					        System.out.println("3. Mostrar saldo");
					        System.out.println("4. Cambiar moneda");
					        System.out.println("5. Volver al menú principal");
					        System.out.print("Opción: ");

					        opcionSubmenuCuenta = scanner.nextInt();
					        scanner.nextLine();

					        switch (opcionSubmenuCuenta) {

					            case 1:
					            	
					            	// depositar dinero
					                System.out.print("Monto a depositar: ");
					                double montoDep = scanner.nextDouble();
					                scanner.nextLine();

					                if (cuenta.depositar(montoDep)) {
					                    System.out.println("Depósito realizado con éxito.");
					                } else {
					                    System.out.println("Monto inválido.");
					                }
					                pausar(scanner);
					                break;

					            case 2:
					            	
					            // Girar dinero
					            	
					                System.out.print("Monto a girar: ");
					                double montoGir = scanner.nextDouble();
					                scanner.nextLine();

					                if (cuenta.girar(montoGir)) {
					                    System.out.println("Retiro realizado con éxito.");
					                } else {
					                    System.out.println("Saldo insuficiente o monto inválido.");
					                }
					                pausar(scanner);
					                break;

					            case 3:
					            	//Consltamos los datos y saldo de cada cuenta
					            	cuenta.obtenerInformacion();
					            	
					            	    pausar(scanner);
					            	    break;
					                
					            case 4:
					            	// Convertimos la moneda a Euro o Dolar
					            	 System.out.println("Seleccione moneda:");
					            	    System.out.println("1. Euro");
					            	    System.out.println("2. USD");

					            	    int opMoneda = scanner.nextInt();
					            	    scanner.nextLine();

					            	    switch (opMoneda) {
					            	        case 1:
					            	            cuenta.mostrarSaldoConvertido(new MonedaEuro());
					            	            break;
					            	        case 2:
					            	            cuenta.mostrarSaldoConvertido(new MonedaUSD());
					            	            break;
					            	        default:
					            	            System.out.println("Moneda inválida");
					            	    }

					            	    pausar(scanner);
					            	    break;
					      

					            case 5:
					            	// Opcion para volver al menu anterior
					                System.out.println("Volviendo al menú Anterior...");
					                break;

					            default:
					                System.out.println("Opción inválida.");
					        }

					    } while (opcionSubmenuCuenta != 5);

					    break;

					    
				 case 3:
					 // Volvemos al menu principal
					 
		                System.out.println("Volviendo al menú principal...");
		                break;

		            default:
		                System.out.println("Opción inválida.");
		        }

		    } while (opcionSubmenu != 3);

		    break;

	
			        
			case 3:
				
				// eliminar usuario (es solo 1 usuario por billetera)
				
			    if (usuario == null) {
			        System.out.println("No hay usuario registrado.");
			    } else {
			        usuario = null;
			        billetera = null;
			        System.out.println("Usuario eliminado correctamente.");
			    }
			    pausar(scanner);
			    break;
			
				
				
			case 4:
				// Termina el programa
				System.out.println("Saliendo de la billetera");
				break;
				
			default:
				System.out.println("Opcion ingresada no es valida.");
				pausar (scanner);
				
				}
			
			}while (opcion != 4);
		
			scanner.close();
			}
		
				
					
			
	// Metodo para poder pausar cada interaccion sin que vuelva inmediatamente al menu principal 
	 private static void pausar(Scanner scanner) {
	        System.out.println("\nPresione ENTER para continuar...");
	        scanner.nextLine();
	       
		
	}
}


