# Budget Standards Application

A web application that displays AFSA Retirement Standards for retirees aged 65-84, allowing users to filter and view budget standards based on different criteria.

 Technical documentation: [https://github.com/preedman/retirement-standard/wiki] 

## Features

- Interactive filtering system for:
    - Lifestyle categories
    - Budget categories
    - Retirement types
- Responsive table display with sortable columns
- Pagination system with adjustable entries per page
- Bootstrap-based modern UI design

## Technologies Used

- Backend:
    - Java 17
    - Spring MVC
    - Spring Data JPA
    - Jakarta EE
- Frontend:
    - JSP (JavaServer Pages)
    - Bootstrap 5.3.2
    - JavaScript
    - JSTL (JavaServer Pages Standard Tag Library)

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17 or higher
- Maven
- Your preferred IDE (Eclipse, IntelliJ IDEA, etc.)
- MySQL/PostgreSQL (or your chosen database)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/budget-standards.git
   ```

2. Navigate to the project directory:
   ```bash
   cd budget-standards
   ```

3. Install dependencies:
   ```bash
   mvn install
   ```

4. Configure your database connection in `application.properties`

5. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Usage

1. Access the application at `http://localhost:8080`
2. Use the filter panel to narrow down budget standards by:
    - Lifestyle
    - Category
    - Retirement Type
3. Adjust the number of entries displayed per page using the dropdown
4. Navigate through pages using the pagination controls

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

Apache - [https://www.apache.org/licenses/LICENSE-2.0]

## Contact

Paul Reedman - [paul.reedman@reedmanit.com](mailto:your.email@example.com)

Project Link: [https://github.com/users/preedman/projects/13](https://github.com/preedman/budget-standards)

## Acknowledgments

- AFSA - [https://www.superannuation.asn.au/consumers/retirement-standard/]
- Bootstrap team for the UI framework
