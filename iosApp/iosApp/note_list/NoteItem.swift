//
//  NoteItem.swift
//  iosApp
//
//  Created by Gaurav Mishra on 18/11/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct NoteItem: View {
    
    var note:Note
    var onDeleteClick:() -> Void
    
    var body: some View {
        VStack(alignment: .leading) {
            HStack {
                Text(note.title)
                    .font(.title3)
                    .fontWeight(.semibold)
                Spacer()
                Button(action: onDeleteClick) {
                    Image(systemName: "xmark").foregroundColor(.black)
                }
            }.padding(.bottom, 3)
            
            Text(note.content)
                .font(.body)
                .fontWeight(.medium)
                .padding(.bottom, 3)
            
            HStack {
                Spacer()
                Text(DateTimeUtil().formatNoteDate(dateTime:note.created))
                    .font(.footnote)
                    .fontWeight(.light)
            }
        }.padding()
        .background(Color(hex: note.colorHex))
        .clipShape(RoundedRectangle(cornerRadius: 5.0))
    }
}

struct NoteItem_Previews: PreviewProvider {
    static var previews: some View {
        NoteItem(
            note: Note(
                id: nil,
                title: "Note",
                content: "Content",
                colorHex: 0xFFAABB,
                created: DateTimeUtil().now()
            ),
            onDeleteClick:{}
        )
    }
}
