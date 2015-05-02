# Minimal Hoplon
This project presents a minimal setup for Hoplon using boot2.

## Dependencies
- Java Development Kit (JDK) version 1.7 or greater
- [boot][boot]

## Usage
### Development
1. Start the `dev` task. In a terminal run:
    ```bash
    $ boot dev
    ```
    This will give you a  Hoplon development setup with:
    - auto compilation on file changes
    - audible warning for compilation success or failures
    - auto reload the html page on changes
    - Clojurescript REPL

2. Open the generated file on `target/index.html` on your browser.

3. To use the Clojurescript REPL on another terminal run:
    ```bash
    $ boot repl -c
    ```
    ```clj
    boot.user=> (start-repl)
    ...
    cljs.user=> (.alert js/window "From the Clojurescript REPL")
    ```
    You should see a popup on the browser.

4. If you edit and save a file, the task will recompile the code and reload the
   browser to show the updated version.

### Production
1. Run the `prod` task. In a terminal run:
    ```bash
    $ boot prod
    ```

2. The compiled files will be on the `target/` directory. This will use
   advanced compilation and prerender the html.

[boot]: https://github.com/boot-clj/boot#install
