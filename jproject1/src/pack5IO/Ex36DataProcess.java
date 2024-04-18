package pack5IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ex36DataProcess {

	public static void main(String[] args) throws Exception{
		// 이진 데이터 처리
		Ex36BinaryData binaryData = new Ex36BinaryData();
		
		// 저장
		//File f = new File("d:/Study/Academy/Acorn/iotest3.dat");
		File dir = new File("d:/Study/Academy/Acorn/"); // 경로만 가지고 있는거
		File file = new File(dir, "iotest3.dat");
		
		FileOutputStream fo = new FileOutputStream(file);
		BufferedOutputStream bo = new BufferedOutputStream(fo, 1024);
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(binaryData);
		oo.close();		bo.close();		fo.close();
		System.out.println("저장 성공");
		
		// 읽기
		File file2 = new File("d:/Study/Academy/Acorn/iotest3.dat");
		FileInputStream fis = new FileInputStream(file2);
		BufferedInputStream bi = new BufferedInputStream(fis, 1024); // 1kb 단위로 처리를 하시오
		ObjectInputStream oi = new ObjectInputStream(bi);
		Object obj = oi.readObject();
		Ex36BinaryData data = (Ex36BinaryData)obj;
		System.out.println(data.a);
		System.out.println(data.b);
		System.out.println(data.ss1);
		System.out.println(data.ss2);
		oi.close(); 	bi.close();		fis.close();
			
	}

}
