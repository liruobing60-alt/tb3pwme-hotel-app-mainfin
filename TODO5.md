## Static Code Analysis (Checkstyle)

This project uses **Checkstyle** for static code analysis.

### How to install

1. Install the VS Code extension **"Checkstyle for Java"**.
2. Open this project folder in VS Code.
3. Checkstyle configuration file is located at: `./checkstyle.xml`.

### How to run

- Right-click on any Java file or the `src` folder and select  
  **"Check Code with Checkstyle"**  
  or  
- Open the Command Palette and run **"Checkstyle: Check Code"**.

The current configuration checks indentation, unused imports, braces, naming conventions, and other basic style rules.

---

## Pre-commit Hook (Static Code Analysis)

This project includes a **pre-commit hook** that automatically runs static code analysis.

### Configuration file

* `.pre-commit-config.yaml`

### How to set up

1. Install the tool:

   ```bash
   pip install pre-commit
   ```
2. In the project root directory, run:

   ```bash
   pre-commit install
   ```
3. The hook will now run automatically before every `git commit`.

### Explanation

* The hook runs `./gradlew.bat check` to perform static code analysis.
* If the analysis fails, the commit is blocked.
* If it passes, the commit succeeds normally.

---