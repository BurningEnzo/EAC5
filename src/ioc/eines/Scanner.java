/*
 * To change this template, choose Tools | Templates
 * and open the template originalSystemIn the editor.
 */
package ioc.eines;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Locale;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

/**
 *
 * @author Josep Cañellas <jcanell4@ioc.cat>
 */
public class Scanner {
    private static java.util.Scanner scanner=null;
    private static java.util.Scanner systemScanner=null;
    private static InputStream originalSystemIn=null;
    private static boolean echo = false;
    
    public Scanner(File source) throws FileNotFoundException{
        scanner = ScannerFactory.createScanner(source);
    }

    public Scanner(File source, String charsetName) throws FileNotFoundException{
        scanner = ScannerFactory.createScanner(source, charsetName);
    }

    public Scanner(InputStream source){
        scanner = ScannerFactory.createScanner(source);
    }

    public Scanner(InputStream source, String charsetName){
        scanner = ScannerFactory.createScanner(source, charsetName);
    }

    public Scanner(Path source) throws IOException{
        scanner = ScannerFactory.createScanner(source);
    }

    public Scanner(Path source, String charsetName) throws IOException{
        scanner = ScannerFactory.createScanner(source, charsetName);
    }

    public Scanner(Readable source){
        scanner = ScannerFactory.createScanner(source);
    }
    

    public Scanner(ReadableByteChannel source){
        scanner = ScannerFactory.createScanner(source);
    }

    public Scanner(ReadableByteChannel source, String charsetName){
        scanner = ScannerFactory.createScanner(source, charsetName);
    }

    public Scanner(String source){
        scanner = ScannerFactory.createScanner(source);
    }
    
    public static InputStream setTestOn(File file) throws IOException{
        InputStream newSystemIn;
        saveSystemIn();
        newSystemIn = new FileInputStream(file);
        echo=true;
        System.setIn(newSystemIn);
        return newSystemIn;
    }

    public static InputStream setTestOn(String input){
        InputStream newSystemIn;
        saveSystemIn();
        newSystemIn  = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        echo=true;
        System.setIn(newSystemIn);
        return newSystemIn;
    }
    
    public static void setTestOff(){
        if(originalSystemIn!=null && System.in!=originalSystemIn){
            if(systemScanner!=null){
                systemScanner.close();
                systemScanner=null;
            }
            echo=false;
            System.setIn(originalSystemIn);
            originalSystemIn=null;
        }
    }
    
    public void	close(){
        scanner.close();
    }

    public Pattern delimiter(){
        return scanner.delimiter();
    }

    public String findInLine(Pattern pattern){
        return scanner.findInLine(pattern);
    }

    public String findInLine(String pattern){
        return scanner.findInLine(pattern);        
    }
    
    public String findWithinHorizon(Pattern pattern, int horizon){
        return scanner.findWithinHorizon(pattern, horizon);    
    }

    public String findWithinHorizon(String pattern, int horizon){
        return scanner.findWithinHorizon(pattern, horizon);    
    }

    public boolean hasNext(){
        return scanner.hasNext();
    }

    public boolean hasNext(Pattern pattern){
        return scanner.hasNext(pattern);        
    }

    public boolean hasNext(String pattern){
        return scanner.hasNext(pattern);        
    }

    public boolean hasNextBigDecimal(){
        return scanner.hasNextBigDecimal();        
    }
    
    public boolean hasNextBigInteger(){
        return scanner.hasNextBigInteger();        
    }
    
    public boolean hasNextBigInteger(int radix){
        return scanner.hasNextBigInteger(radix);        
    }    
    public boolean hasNextBoolean(){
        return scanner.hasNextBoolean();
    }

    public boolean hasNextByte(){
        return scanner.hasNextByte();
    }
    
    public boolean hasNextByte(int radix){
        return scanner.hasNextByte(radix);
    }
    
    public boolean hasNextDouble(){
        return scanner.hasNextDouble();
    }
    
    public boolean hasNextFloat(){
        return scanner.hasNextFloat();
    }
    
    public boolean hasNextInt(){
        return scanner.hasNextInt();
    }
    
    public boolean hasNextInt(int radix){
        return scanner.hasNextInt(radix);
    }
    
    public boolean hasNextLine(){
        return scanner.hasNextLine();
    }
    
    public boolean hasNextLong(){
        return scanner.hasNextLong();
    }
    
    public boolean hasNextLong(int radix){
        return scanner.hasNextLong(radix);
    }
    
    public boolean hasNextShort(){
        return scanner.hasNextShort();
    }
    
    public boolean hasNextShort(int radix){
        return scanner.hasNextShort(radix);
    }
    
    public IOException ioException(){
        return scanner.ioException();
    }
    
    public Locale locale(){
        return scanner.locale();
    }
    
    public MatchResult match(){
        return scanner.match();
    }
    
    public String next(){
        String ret;
        if(originalSystemIn!=null){
            try{
                ret = scanner.next();            
            }catch(java.util.NoSuchElementException ex){
                InputStream aux = originalSystemIn;
                setTestOff();
                scanner = ScannerFactory.createScanner(aux);
                ret = scanner.next();
            }
        }else{
            ret = scanner.next();
        }
        if(echo){
            System.out.print(ret);
        }
        return ret;
    }
    
    public String next(Pattern pattern){
        String ret;
        if(originalSystemIn!=null){
            try{
                ret = scanner.next(pattern);            
            }catch(java.util.NoSuchElementException ex){
                InputStream aux = originalSystemIn;
                setTestOff();
                scanner = ScannerFactory.createScanner(aux);
                ret = scanner.next(pattern);
            }
        }else{
            ret = scanner.next(pattern);
        }
        if(echo){
            System.out.print(ret);
        }
        return ret;
    }
    
    public String next(String pattern){
        String ret;
        if(originalSystemIn!=null){
            try{
                ret = scanner.next(pattern);            
            }catch(java.util.NoSuchElementException ex){
                InputStream aux = originalSystemIn;
                setTestOff();
                scanner = ScannerFactory.createScanner(aux);
                ret = scanner.next(pattern);
            }
        }else{
            ret = scanner.next(pattern);
        }
        if(echo){
            System.out.print(ret);
        }
        return ret;
    }
    
    public BigDecimal nextBigDecimal(){
        BigDecimal ret;
        if(originalSystemIn!=null){
            try{
                ret = scanner.nextBigDecimal();            
            }catch(java.util.NoSuchElementException ex){
                InputStream aux = originalSystemIn;
                setTestOff();
                scanner = ScannerFactory.createScanner(aux);
                ret = scanner.nextBigDecimal();
            }
        }else{
            ret = scanner.nextBigDecimal();
        }
        if(echo){
            System.out.print(ret);
        }
        return ret;                                                
    }
    
    public BigInteger nextBigInteger(){
        BigInteger ret;
        if(originalSystemIn!=null){
            try{
                ret = scanner.nextBigInteger();            
            }catch(java.util.NoSuchElementException ex){
                InputStream aux = originalSystemIn;
                setTestOff();
                scanner = ScannerFactory.createScanner(aux);
                ret = scanner.nextBigInteger();
            }
        }else{
            ret = scanner.nextBigInteger();
        }
        if(echo){
            System.out.print(ret);
        }
        return ret;                                        
    }
    
    public BigInteger nextBigInteger(int radix){
        BigInteger ret;
        if(originalSystemIn!=null){
            try{
                ret = scanner.nextBigInteger(radix);            
            }catch(java.util.NoSuchElementException ex){
                InputStream aux = originalSystemIn;
                setTestOff();
                scanner = ScannerFactory.createScanner(aux);
                ret = scanner.nextBigInteger(radix);
            }
        }else{
            ret = scanner.nextBigInteger(radix);
        }
        if(echo){
            System.out.print(ret);
        }
        return ret;                                        
    }
    
    public boolean nextBoolean(){
        boolean ret;
        if(originalSystemIn!=null){
            try{
                ret = scanner.nextBoolean();
            }catch(java.util.NoSuchElementException ex){
                InputStream aux = originalSystemIn;
                setTestOff();
                scanner = ScannerFactory.createScanner(aux);
                ret = scanner.nextBoolean();
            }
        }else{
            ret = scanner.nextBoolean();
        }
        if(echo){
            System.out.print(ret);
        }
        return ret;                                                
    }
    
    public byte nextByte(){
        byte ret;
        if(originalSystemIn!=null){
            try{
                ret = scanner.nextByte();
            }catch(java.util.NoSuchElementException ex){
                InputStream aux = originalSystemIn;
                setTestOff();
                scanner = ScannerFactory.createScanner(aux);
                ret = scanner.nextByte();
            }
        }else{
            ret = scanner.nextByte();
        }
        
        if(echo){
            System.out.print(ret);
        }
        return ret;                                        
    }
    
    public byte nextByte(int radix){
        byte ret;
        if(originalSystemIn!=null){
            try{
                ret = scanner.nextByte(radix);
            }catch(java.util.NoSuchElementException ex){
                InputStream aux = originalSystemIn;
                setTestOff();
                scanner = ScannerFactory.createScanner(aux);
                ret = scanner.nextByte(radix);
            }
        }else{
            ret = scanner.nextByte(radix);
        }
        if(echo){
            System.out.print(ret);
        }
        return ret;                                                
    }
    
    public double nextDouble(){
        double ret;
        if(originalSystemIn!=null){
            try{
                ret = scanner.nextDouble();
            }catch(java.util.NoSuchElementException ex){
                InputStream aux = originalSystemIn;
                setTestOff();
                scanner = ScannerFactory.createScanner(aux);
                ret = scanner.nextDouble();
            }
        }else{
            ret = scanner.nextDouble();
        }
        if(echo){
            System.out.print(ret);
        }
        return ret;                                        
    }
    
    public float nextFloat(){
        float ret;
        if(originalSystemIn!=null){
            try{
                ret = scanner.nextFloat();
            }catch(java.util.NoSuchElementException ex){
                InputStream aux = originalSystemIn;
                setTestOff();
                scanner = ScannerFactory.createScanner(aux);
                ret = scanner.nextFloat();
            }
        }else{
            ret = scanner.nextFloat();
        }
        if(echo){
            System.out.print(ret);
        }
        return ret;                                
    }
    
    public int nextInt(){
        int ret;
        if(originalSystemIn!=null){
            try{
                ret = scanner.nextInt();
            }catch(java.util.NoSuchElementException ex){
                InputStream aux = originalSystemIn;
                setTestOff();
                scanner = ScannerFactory.createScanner(aux);
                ret = scanner.nextInt();
            }
        }else{
            ret = scanner.nextInt();
        }
        if(echo){
            System.out.print(ret);
        }
        return ret;                        
    }
    
    public int nextInt(int radix){
        int ret;
        if(originalSystemIn!=null){
            try{
                ret = scanner.nextInt(radix);
            }catch(java.util.NoSuchElementException ex){
                InputStream aux = originalSystemIn;
                setTestOff();
                scanner = ScannerFactory.createScanner(aux);
                ret = scanner.nextInt(radix);
            }
        }else{
            ret = scanner.nextInt(radix);
        }
        if(echo){
            System.out.print(ret);
        }
        return ret;                
    }
    
    public String nextLine(){
        String ret;
        if(originalSystemIn!=null){
            try{
                ret = scanner.nextLine();
            }catch(java.util.NoSuchElementException ex){
                InputStream aux = originalSystemIn;
                setTestOff();
                scanner = ScannerFactory.createScanner(aux);
                ret = scanner.nextLine();
            }
        }else{
            ret = scanner.nextLine();
        }
        if(echo){
            System.out.println(ret);
        }
        return ret;                
    }
    
    public long nextLong(){
        long ret;
        if(originalSystemIn!=null){
            try{
                ret = scanner.nextLong();
            }catch(java.util.NoSuchElementException ex){
                InputStream aux = originalSystemIn;
                setTestOff();
                scanner = ScannerFactory.createScanner(aux);
                ret = scanner.nextLong();
            }
        }else{
            ret = scanner.nextLong();
        }
        if(echo){
            System.out.print(ret);
        }
        return ret;        
    }
    
    public long nextLong(int radix){
        long ret;
        if(originalSystemIn!=null){
            try{
                ret = scanner.nextLong(radix);
            }catch(java.util.NoSuchElementException ex){
                InputStream aux = originalSystemIn;
                setTestOff();
                scanner = ScannerFactory.createScanner(aux);
                ret = scanner.nextLong(radix);
            }
        }else{
            ret = scanner.nextLong(radix);
        }
        if(echo){
            System.out.print(ret);
        }
        return ret;
    }
    
    public short nextShort(){
        short ret;
        if(originalSystemIn!=null){
            try{
                ret = scanner.nextShort();
            }catch(java.util.NoSuchElementException ex){
                InputStream aux = originalSystemIn;
                setTestOff();
                scanner = ScannerFactory.createScanner(aux);
                ret = scanner.nextShort();
            }
        }else{
            ret = scanner.nextShort();
        }
        if(echo){
            System.out.print(ret);
        }
        return ret;
    }
    
    public short nextShort(int radix){
        short ret;
        if(originalSystemIn!=null){
            try{
                ret = scanner.nextShort(radix);
            }catch(java.util.NoSuchElementException ex){
                InputStream aux = originalSystemIn;
                setTestOff();
                scanner = ScannerFactory.createScanner(aux);
                ret = scanner.nextShort(radix);
            }
        }else{
            ret = scanner.nextShort(radix);
        }
        if(echo){
            System.out.print(ret);
        }
        return ret;
    }
    
    public int radix(){
        return scanner.radix();
    }
    
    public void remove(){
        scanner.remove();
    }
    
    public Scanner reset(){
        scanner.reset();
        return this;
    }
    
    public Scanner skip(Pattern pattern){
        if(originalSystemIn!=null){
            try{
                scanner.skip(pattern);
            }catch(java.util.NoSuchElementException ex){
                InputStream aux = originalSystemIn;
                setTestOff();
                scanner = ScannerFactory.createScanner(aux);
                scanner.skip(pattern);
            }
        }else{
            scanner.skip(pattern);
        }
        return this;
    }
    
    public Scanner skip(String pattern){
        if(originalSystemIn!=null){
            try{
                scanner.skip(pattern);
            }catch(java.util.NoSuchElementException ex){
                InputStream aux = originalSystemIn;
                setTestOff();
                scanner = ScannerFactory.createScanner(aux);
                scanner.skip(pattern);
            }
        }else{
            scanner.skip(pattern);
        }
        return  this;
    }
    
    public String toString(){
        return scanner.	toString();
    }
    
    public Scanner useDelimiter(Pattern pattern){
        scanner.useDelimiter(pattern);
        return this;
    }
    
    public Scanner useDelimiter(String pattern){
        scanner.useDelimiter(pattern);
        return this;
    }
    
    public Scanner useLocale(Locale locale){
        scanner.useLocale(locale);
        return this;
    }
    
    public Scanner useRadix(int radix){
        scanner.useRadix(radix);
        return this;
    }
    
    private static void saveSystemIn(){
        setTestOff();
        originalSystemIn = System.in;
    }
    
    private static class ScannerFactory{
        public static java.util.Scanner createScanner(File source) throws FileNotFoundException{
            return new java.util.Scanner(source);
        }
    
        public static java.util.Scanner createScanner(File source, String charsetName) throws FileNotFoundException{
            return new java.util.Scanner(source);
        }
    
        public static java.util.Scanner createScanner(InputStream source){
            java.util.Scanner ret = null;
            if(source!=null && source.equals(System.in)){
                if(systemScanner==null){
                    systemScanner=new java.util.Scanner(source);
                }
                ret = systemScanner;
            }else{
                ret = new java.util.Scanner(source);
            }
            return ret;
        }
    
        public static java.util.Scanner createScanner(InputStream source, String charsetName){
            java.util.Scanner ret = null;
            if(source!=null && source.equals(System.in)){
                if(systemScanner==null){
                    systemScanner=new java.util.Scanner(source, charsetName);
                }
                ret = systemScanner;
            }else{
                ret = new java.util.Scanner(source, charsetName);
            }
            return ret;
        }
    
        public static java.util.Scanner createScanner(Path source) 
                                                            throws IOException{
            return new java.util.Scanner(source);
        }
    
        public static java.util.Scanner createScanner(
                                              Path source, 
                                              String charsetName) 
                                                            throws IOException{
            return new java.util.Scanner(source, charsetName);
        }
    
        public static java.util.Scanner createScanner(Readable source){
            return new java.util.Scanner(source);
        }

        public static java.util.Scanner createScanner(ReadableByteChannel source){
            return new java.util.Scanner(source);
        }

        public static java.util.Scanner createScanner(
                                    ReadableByteChannel source, 
                                    String charsetName){
            return new java.util.Scanner(source, charsetName);
        }

        public static java.util.Scanner createScanner(String source){
            return new java.util.Scanner(source);
        }
    }
}

