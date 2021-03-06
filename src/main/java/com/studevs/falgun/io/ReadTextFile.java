/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studevs.falgun.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ashik
 */
public class ReadTextFile {

    private Scanner scanner;
    private String filePath;
    private int globalLineCounter;
    private int initialLineNumber;
    private int terminalLineNumber;

    public ReadTextFile(String filePath) {

        try {

            this.filePath = filePath;
            this.globalLineCounter = 0;
            this.initialLineNumber = 0;
            this.terminalLineNumber = 0;
            this.scanner = new Scanner(new File(this.filePath));
        } catch (Exception e) {

            System.err.println(e.toString());
        }
    }

    public void setFilePath(String filePath) {

        try {

            this.globalLineCounter = 0;
            this.initialLineNumber = 0;
            this.terminalLineNumber = 0;
            this.filePath = filePath;
            this.scanner = new Scanner(new File(this.filePath));
        } catch (Exception e) {

            System.err.println(e.toString());
        }
    }

    public boolean reset() {

        try {

            this.globalLineCounter = 0;
            this.scanner = new Scanner(new File(this.filePath));
            return true;
        } catch (Exception e) {

            System.err.println(e.toString());
            return false;
        }
    }

    public boolean hasNext() {

        try {

            return this.scanner.hasNext();
        } catch (Exception e) {

            System.err.println(e.toString());
            return false;
        }
    }

    public String readNextWord() {

        try {

            return this.scanner.next();
        } catch (Exception e) {

            System.err.println(e.toString());
            return null;
        }
    }

    public String readNextLine() {

        try {

            return this.scanner.nextLine();
        } catch (Exception e) {

            System.err.println(e.toString());
            return null;
        }
    }

    private String[] readWords() {

        try {

            if (this.globalLineCounter > this.initialLineNumber) {

                this.reset();
            }

            List<String> wordList = new ArrayList<>();

            if (this.initialLineNumber <= this.terminalLineNumber) {

                while (this.globalLineCounter < this.initialLineNumber && this.scanner.hasNext()) {

                    this.scanner.next();
                    this.globalLineCounter++;
                }

                while (this.globalLineCounter <= this.terminalLineNumber && this.scanner.hasNext()) {

                    wordList.add(this.scanner.next());
                    this.globalLineCounter++;
                }

                String[] words = new String[wordList.size()];

                for (int i = 0; i < wordList.size(); i++) {

                    words[i] = wordList.get(i);
                }

                return words;
            } else {

                System.err.println("Starting position must be less than or equal to terminal position.");
                return null;
            }
        } catch (Exception e) {

            System.err.println(e.toString());
            return null;
        }
    }

    private String[] readLines() {

        try {

            if (this.globalLineCounter > this.initialLineNumber) {

                this.reset();
            }

            List<String> lineList = new ArrayList<>();

            if (this.initialLineNumber <= this.terminalLineNumber) {

                while (this.globalLineCounter < this.initialLineNumber && this.scanner.hasNext()) {

                    this.scanner.nextLine();
                    this.globalLineCounter++;
                }

                while (this.globalLineCounter <= this.terminalLineNumber && this.scanner.hasNext()) {

                    lineList.add(this.scanner.nextLine());
                    this.globalLineCounter++;
                }

                String[] lines = new String[lineList.size()];

                for (int i = 0; i < lineList.size(); i++) {

                    lines[i] = lineList.get(i);
                }

                return lines;
            } else {

                System.err.println("Starting position must be less than or equal to terminal position.");
                return null;
            }
        } catch (Exception e) {

            System.err.println(e.toString());
            return null;
        }
    }

    public String[] readNextWordsFrom(int initialWordNumber, int terminalWordNumber) {

        try {

            this.initialLineNumber = initialWordNumber;
            this.terminalLineNumber = terminalWordNumber;
            return this.readWords();
        } catch (Exception e) {

            System.err.println(e.toString());
            return null;
        }
    }

    public String[] readNextLinesFrom(int initialLineNumber, int terminalLineNumber) {

        try {

            this.initialLineNumber = initialLineNumber;
            this.terminalLineNumber = terminalLineNumber;
            return this.readLines();
        } catch (Exception e) {

            System.err.println(e.toString());
            return null;
        }
    }

    public String[] readNextWordsFrom(int initialWordNumber) {

        try {

            this.initialLineNumber = initialWordNumber;
            this.terminalLineNumber = Integer.MAX_VALUE;
            return this.readWords();
        } catch (Exception e) {

            System.err.println(e.toString());
            return null;
        }
    }

    public String[] readNextLinesFrom(int initialLineNumber) {

        try {

            this.initialLineNumber = initialLineNumber;
            this.terminalLineNumber = Integer.MAX_VALUE;
            return this.readLines();
        } catch (Exception e) {

            System.err.println(e.toString());
            return null;
        }
    }

    public String[] readNextWordsTo(int terminalWordNumber) {

        try {

            this.initialLineNumber = 0;
            this.terminalLineNumber = terminalWordNumber;
            return this.readWords();
        } catch (Exception e) {

            System.err.println(e.toString());
            return null;
        }
    }

    public String[] readNextLinesTo(int terminalLineNumber) {

        try {

            this.initialLineNumber = 0;
            this.terminalLineNumber = terminalLineNumber;
            return this.readLines();
        } catch (Exception e) {

            System.err.println(e.toString());
            return null;
        }
    }

    public int getCounter() {

        try {

            return this.globalLineCounter + 1;
        } catch (Exception e) {

            System.err.println(e.toString());
            return -1;
        }
    }

    public void close() {

        try {

            this.scanner.close();
        } catch (Exception e) {

            System.err.println(e.toString());
        }
    }
}
