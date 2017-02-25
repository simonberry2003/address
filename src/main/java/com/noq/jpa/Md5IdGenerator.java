package com.noq.jpa;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.google.common.base.Preconditions;

import lombok.val;

public class Md5IdGenerator implements IdentifierGenerator {

	private static final MessageDigest md;

	static {
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		Preconditions.checkNotNull(object);
		try {
			val hashable = (Hashable) object;
			byte[] bytesOfMessage = hashable.getHashString().getBytes("UTF-8");
			byte[] thedigest = md.digest(bytesOfMessage);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < thedigest.length; i++) {
				sb.append(Integer.toString((thedigest[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String generate(Hashable hashable) {
		Preconditions.checkNotNull(hashable);
		return new Md5IdGenerator().generate(null, hashable).toString();
	}
}
